package ast;

import sem_an.Environment;
import sem_an.simpLanPlusError;
import sem_an.SemanticError;
import sem_an.SymbolTableEntry;

import java.util.ArrayList;

public class AsgNode implements Node{

    private String id;
    private Node exp;

    SymbolTableEntry st;
    private int nesting;
    private int nestingNode;

    public AsgNode(String id, Node exp) {
        this.id = id;
        this.exp = exp;
    }
    @Override
    public ArrayList<SemanticError> checkSemantics(Environment e) {
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();
        st = e.getSymbolTable().lookup(id);
        nestingNode = e.getSymbolTable().nestingLookup(id);
        nesting = e.getNestingLevel();
        if(st == null){
            throw new simpLanPlusError("Variable "+this.id+" not declared in the current scope.");
        } else if(this.exp != null) {
            res.addAll(this.exp.checkSemantics(e));
        }
        return res;
    }

    @Override
    public TypeNode typeCheck(Environment e) throws Error {
        if (st == null) {
            throw new Error();
        }
        TypeNode expNode = this.exp.typeCheck(e);
        if(!st.getType().getType().equals(expNode.getType())){
            throw new simpLanPlusError("TypeChecking error: incompatible expressions during assignment.");
        }
        st.setInitialized();
        return expNode;
    }

    @Override
    public String printNode(String s) {
        return s + "Var:" + id + "\n" + exp.printNode(s+"\t");
    }

    @Override
    public String codeGeneration(Environment e) {

        String getAR="";
        for (int i = 0; i < nesting - nestingNode; i++)
            getAR += "store T1 0(T1) \n";


        return exp.codeGeneration(e) +
                "move AL T1 \n"
                //static chain
                + getAR
                //offset on the stack
                + "subi T1 " + st.getOffset()+ "\n"
                + "load A0 0(T1) \n";
    }
}
