package ast;

import sem_an.Environment;
import sem_an.SemanticError;

import java.util.ArrayList;

public interface Node {
    ArrayList<SemanticError> checkSemantics(Environment e);
    TypeNode typeCheck(Environment e);
    String printNode(String s);
    String codeGeneration(Environment localenv);
}
