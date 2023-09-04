package ast;

import sem_an.SymbolTableEntry;
import sem_an.*;

import java.util.ArrayList;

public class IdNode implements Node{
    private String id;
    SymbolTableEntry s;

    private int nesting;
    private int nestingNode;
    public IdNode(String id) {
        this.id = id;
    }

    @Override
    public ArrayList<sem_an.SemanticError> checkSemantics(sem_an.Environment e) {;

        ArrayList<sem_an.SemanticError> result = new ArrayList<sem_an.SemanticError>();
        s= e.getSymbolTable().lookup(this.id);

        this.nestingNode = e.getSymbolTable().nestingLookup(this.id);
        this.nesting = e.getNestingLevel();
        if (s==null)
            result.add(new sem_an.SemanticError("Variable "+this.id+" not declared."));
        return result;
    }

    @Override
    public TypeNode typeCheck(sem_an.Environment e) throws Error{
        if(s == null) {
            //not declared
            throw new simpLanPlusError("TypeChecking Error: variable "+this.id+" was not declared.");
        }
        //typecheck end exp
        if (s.getStatus() == sem_an.Status.DECLARED) {
            throw new simpLanPlusError("TypeChecking Error: variable "+s.getLabel()+" was declared but not initialized.");
        }
        return s.getType();
    }

    @Override
    public String printNode(String s) {
        return s+this.id;
    }

    @Override
    public String codeGeneration(sem_an.Environment e) {

        String getAR="";
        for (int i = 0; i < nesting - nestingNode; i++)
            getAR += "store T1 0(T1) \n";

        return  "move AL T1 \n"
                + getAR
                + "subi T1 " + s.getOffset() + "\n"
                + "store A0 0(T1) \n";
    }

    public String getId() {
        return this.id;
    }
}
