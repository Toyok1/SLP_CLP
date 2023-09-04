package ast;

import sem_an.Environment;
import sem_an.SemanticError;

import java.util.ArrayList;

public class DecNode implements Node {
    private String id;
    private TypeNode type;

    public DecNode(String i, TypeNode t) {
        id = i ;
        type = t ;
    }

    public ArrayList<SemanticError> checkSemantics(Environment e) {
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
        if (e.getSymbolTable().topLookup(id) != null)
            errors.add(new SemanticError("Variable " + id + " already declared in this scope."));
        else {

            e.getSymbolTable().insert(id, type, e.getOffset()) ;
            e.incrementOffset();
        }
        return errors ;
    }

    public TypeNode typeCheck (Environment e) {
        return null;
    }

    public String codeGeneration(Environment e) {
        return "subi SP 1 \n";
    }

    public String printNode(String s) {
        return "Variable: "+this.id+": "+this.type.getType();
    }

}