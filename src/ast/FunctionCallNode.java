package ast;

import sem_an.Environment;
import sem_an.simpLanPlusError;
import sem_an.SemanticError;
import sem_an.SymbolTableEntry;

import java.util.ArrayList;

public class FunctionCallNode implements Node{
    String id;
    ArrayList<Node> params;
    SymbolTableEntry st;
    private int nesting;

    private int nestingNode;

    public FunctionCallNode(String id, ArrayList<Node> params) {
        this.id = id;
        this.params = params;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment e) {
        ArrayList<SemanticError> results = new ArrayList<SemanticError>();

        nestingNode = e.getSymbolTable().nestingLookup(this.id);
        nesting = e.getNestingLevel();
        if (e.getSymbolTable().lookup(id) == null)
            results.add(new SemanticError("Function " + this.id + " was not declared."));
        else {
            st = e.getSymbolTable().lookup(this.id);
            if (this.params != null)
                for (Node par : params)
                    results.addAll(par.checkSemantics(e));
        }
        return results;
    }

    @Override
    public TypeNode typeCheck(Environment e) {
        TypeNode t = st.getType();
        if(!t.isFunction()) {
            throw new simpLanPlusError("Invocation error: "+this.id+" is not a function.");
        }

        ArrayList<TypeNode> expectedParams = t.getParams();

        if(this.params.size() != expectedParams.size()) {
            throw new simpLanPlusError("Invocation error: "+this.id+". wrong argument number.");
        }

        //Controllo dei tipi dei formali e attuali

        for(int i=0; i<this.params.size();i++) {
            if(!this.params.get(i).typeCheck(e).getType().equals(expectedParams.get(i).getType())) {
                throw new simpLanPlusError("Errore durante l'invocazione di "+this.id+". Tipo errato per il "+(i+1)+" parametro.");
            }

            if(this.params.get(i).getClass() == IfExpNode.class || this.params.get(i).getClass() == IfStmNode.class) {
                throw new simpLanPlusError("Errore durante l'invocazione di "+this.id+". Operatore If Then Else non consentito come parametro.");
            }
        }

    return t;
    }

    @Override
    public String printNode(String s) {
        return this.id+" :"+this.params.toString();
    }

    @Override
    public String codeGeneration(Environment e) {
        String parCode="";
        for (int i = 0; i < this.params.size() ; i = i+1)
            parCode += this.params.get(i).codeGeneration(e) + "pushr A0\n" ;

        String getAR="";

        for (int i=0; i < nesting - nestingNode; i++)
            getAR+="store T1 0(T1) \n";
        // formato AR: control_link + access link + parameters + indirizzo di ritorno + dich_locali

        return  "pushr FP \n"			// carico il frame pointer
                + "move SP FP \n"
                + "addi FP 1 \n"	// salvo in FP il puntatore all'indirizzo del frame pointer caricato
                + "move AL T1\n"		// risalgo la catena statica
                + getAR
                + "pushr T1 \n"			// salvo sulla pila l'access link statico
                + parCode 				// calcolo i parametri attuali con l'access link del chiamante
                + "move FP AL \n"
                + "subi AL 1 \n"
                + "jsub " + st.getLabel() + "\n" ;
    }
}