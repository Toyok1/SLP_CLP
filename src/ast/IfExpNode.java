package ast;

import simpLanPlusLib.SimpLanPluslib;
import sem_an.SymbolTableEntry;
import sem_an.*;

import java.util.ArrayList;
import java.util.Hashtable;

public class IfExpNode implements Node{
    Node condition;
    ArrayList<Node> innerThenStatements;
    Node innerThenExp;
    ArrayList<Node> innerElseStatements;
    Node innerElseExp;


    public IfExpNode(Node condition, ArrayList<Node> innerThenDeclarations, ArrayList<Node> innerThenStatements, Node innerThenExp, ArrayList<Node> innerElseDeclarations, ArrayList<Node> innerElseStatements, Node innerElseExp ) {
        this.condition = condition;
        this.innerThenStatements = innerThenStatements;
        this.innerThenExp = innerThenExp;
        this.innerElseStatements = innerElseStatements;
        this.innerElseExp = innerElseExp;
    }

    @Override
    public ArrayList<sem_an.SemanticError> checkSemantics(sem_an.Environment e) {

        ArrayList<sem_an.SemanticError> result = new ArrayList<sem_an.SemanticError>();
        result.addAll(condition.checkSemantics(e));

        sem_an.Environment tmp = new sem_an.Environment(e);


        for(Node n: innerThenStatements){
            result.addAll(n.checkSemantics(e));
        }
        result.addAll(innerThenExp.checkSemantics(e));

        if(innerElseStatements != null) {

            for (Node n : innerElseStatements) {
                result.addAll(n.checkSemantics(tmp));
            }
            result.addAll(innerElseExp.checkSemantics(tmp));
        }
        return result;
    }

    @Override
    public TypeNode typeCheck(sem_an.Environment e) {
        if (!condition.typeCheck(e).getType().equals("bool") )
            throw new simpLanPlusError("TypeChecking Error: condition type must be boolean.");

        sem_an.Environment tmp = new sem_an.Environment(e);

        for(Node n: innerThenStatements){
            n.typeCheck(e);
        }
        TypeNode thenTypeNode = innerThenExp.typeCheck(e);

        if(innerElseStatements != null) {
            for (Node n : innerElseStatements) {
                n.typeCheck(tmp);
            }
            TypeNode elseTypeNode = innerElseExp.typeCheck(tmp);

            if(!thenTypeNode.getType().equals(elseTypeNode.getType()))
                throw new simpLanPlusError("TypeChecking Error: the then and else branch must return the same type.");

            for(int i=0; i<e.getSymbolTable().getSize(); i++) {
                Hashtable<String, sem_an.SymbolTableEntry> tmp1 = e.getSymbolTable().get(i);
                Hashtable<String, SymbolTableEntry> tmp2 = tmp.getSymbolTable().get(i);
                for(String elem: tmp1.keySet()) {
                    if((tmp1.get(elem).getStatus() == sem_an.Status.INITIALIZED && tmp2.get(elem).getStatus() == sem_an.Status.DECLARED) || (tmp1.get(elem).getStatus() == sem_an.Status.DECLARED && tmp2.get(elem).getStatus() == sem_an.Status.INITIALIZED)) {
                        throw new simpLanPlusError("Assingment incompatibility for variable "+tmp1.get(elem).getLabel() + " between the then and else branches.");
                    }
                }
            }
        } else {
            e=tmp;
        }
        return thenTypeNode;
    }

    @Override
    public String printNode(String s) {
        return null;
    }

    @Override
    public String codeGeneration(sem_an.Environment e)
    {
        String lthen = SimpLanPluslib.newLabel();
        String lend = SimpLanPluslib.newLabel();

        String stmThen = "";
        for(Node stm: innerThenStatements)
            stmThen = stmThen + stm.codeGeneration(e);

        String stmElse = "";
        for(Node stm: innerElseStatements)
            stmElse = stmElse + stm.codeGeneration(e);


        return condition.codeGeneration(e) +
            "storei T1 1 \n" +
            "beq A0 T1 "+ lthen + "\n" +
                stmElse +
                 innerElseExp.codeGeneration(e) +
            "b " + lend + "\n" +
            lthen + ":\n" +
                stmThen +
               innerThenExp.codeGeneration(e) +
            lend + ":\n" ;     }
}
