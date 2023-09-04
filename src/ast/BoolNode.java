package ast;

import sem_an.Environment;
import sem_an.SemanticError;

import java.util.ArrayList;

public class BoolNode implements Node{
    private boolean val;

    public BoolNode(boolean v) {
        this.val = v;
    }
    @Override
    public ArrayList<SemanticError> checkSemantics(Environment e) {
        return new ArrayList<SemanticError>();
    }

    @Override
    public TypeNode typeCheck(Environment e) {
        return new TypeNode("bool");
    }

    @Override
    public String printNode(String s) {
        return s+this.val;
    }

    @Override
    public String codeGeneration(Environment e) {
        return "storei A0 "+(this.val ? 1 : 0)+"\n";
    }
}
