package ast;

import simpLanPlusLib.SimpLanPluslib;
import sem_an.Environment;
import sem_an.simpLanPlusError;
import sem_an.SemanticError;
import sem_an.SymbolTable;

import java.util.ArrayList;

public class DecFunctionNode implements Node{
    private TypeNode type;
    private String id;
    private ArrayList<Node> params;
    private ArrayList<Node> innerDecs;
    private ArrayList<Node> innerStatements;
    private Node innerExp;
    private String functionLabel;

    public DecFunctionNode(Node type, String id, ArrayList<Node> params, ArrayList<Node> innerDecs, ArrayList<Node> innerStatements, Node innerExp) {
        this.type = (TypeNode) type;
        this.id = id;
        this.params = params;
        this.innerDecs = innerDecs;
        this.innerStatements = innerStatements;
        this.innerExp = innerExp;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment e) {

        ArrayList<SemanticError> results = new ArrayList<>();
        SymbolTable st = e.getSymbolTable();
        if (st.lookup(this.id) != null) {
            results.add(new SemanticError("Function name " +this.id +" already used in this scope."));
            return results;
        }


        ArrayList<TypeNode> paramsList = new ArrayList<>();
        if(this.params != null) {
            for(Node p: this.params) {
                ArgNode tmp = (ArgNode) p;
                paramsList.add(new TypeNode(tmp.getType().getType()));
            }
        }

        TypeNode function = new TypeNode(this.type.getType(), paramsList);
        this.functionLabel = SimpLanPluslib.newFunctionLabel() ;


        e.getSymbolTable().insert(this.id, function,-1, this.functionLabel);

        e.enterInNewBlock();

        for(Node arg: params) {
            results.addAll(arg.checkSemantics(e));
        }

        e.incrementOffset();

        for(Node dec: innerDecs) {
            results.addAll(dec.checkSemantics(e));
        }

        for(Node stm: innerStatements) {
            results.addAll(stm.checkSemantics(e));
        }

        if(innerExp != null)
            results.addAll(innerExp.checkSemantics(e));


        e.exitFromBlock();
        return results;
    }

    @Override
    public TypeNode typeCheck(Environment e) throws Error {
        if (innerDecs != null)
            for(Node innerD: this.innerDecs)
                innerD.typeCheck(e);
        if (innerStatements != null)
            for(Node innerS: this.innerStatements)
                innerS.typeCheck(e);

        if (innerExp != null) {
            TypeNode returnType = innerExp.typeCheck(e);
            if (!returnType.getType().equals(this.type.getType()))
                throw new simpLanPlusError("TypoeChecking error: the return type is different from the expected one.");
        }
        return this.type;
    }

    @Override
    public String printNode(String s) {
        String parlstr="";
        for (Node par:params){
            parlstr += par.printNode(s);
        }
        String declstr= "";
        return s+"Function:" + id +"\n"
                +parlstr
                +declstr
                + "\n";
    }

    @Override
    public String codeGeneration(Environment e)
    {
        int paramSpace = this.params.size();
        String declarationCode = "" ;
        if (innerDecs.size() != 0) {
            for (Node dec:innerDecs) declarationCode += dec.codeGeneration(e);
        }

        String innerStmCode = "";
        if (innerStatements != null)
            for(Node innerS: this.innerStatements) innerStmCode += innerS.codeGeneration(e);

        String innerExpCode = "";
        if (innerExp != null) innerExpCode += innerExp.codeGeneration(e);



        SimpLanPluslib.addCode(
                functionLabel + ":\n"
                        + "pushr RA \n"
                        + declarationCode
                        + innerStmCode
                        + innerExpCode
                        + "addi SP " + 	innerDecs.size() + "\n"
                        + "popr RA \n"
                        + "addi SP " + 	paramSpace + "\n"
                        + "pop \n"
                        + "store FP 0(FP) \n"
                        + "move FP AL \n"
                        + "subi AL 1 \n"
                        + "pop \n"
                        + "rsub RA \n"
        );
        return "push "+ functionLabel +"\n";
    }
}
