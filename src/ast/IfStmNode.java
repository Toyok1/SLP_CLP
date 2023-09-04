package ast;

import simpLanPlusLib.SimpLanPluslib;
import sem_an.SymbolTableEntry;
import sem_an.simpLanPlusError;

import java.util.ArrayList;
import java.util.Hashtable;

public class IfStmNode implements Node{
    Node condition;
    ArrayList<Node> then_node_statements;
    ArrayList<Node> else_node_statements;


    public IfStmNode(Node condition, ArrayList<Node> then_node_statements, ArrayList<Node> else_node_statements) {
        this.condition = condition;
        this.then_node_statements = then_node_statements;

        this.else_node_statements = else_node_statements;
    }

    @Override
    public ArrayList<sem_an.SemanticError> checkSemantics(sem_an.Environment e) {
        ArrayList<sem_an.SemanticError> result = new ArrayList<sem_an.SemanticError>();
        result.addAll(condition.checkSemantics(e));
        sem_an.Environment tmp = new sem_an.Environment(e);

        for(Node s: then_node_statements) {
            result.addAll(s.checkSemantics(e));
        }

        if(else_node_statements != null) {

            for (Node s : else_node_statements) {
                result.addAll(s.checkSemantics(tmp));
            }
        }
        return result;
    }

    @Override
    public TypeNode typeCheck(sem_an.Environment e) throws simpLanPlusError {
        if (!condition.typeCheck(e).getType().equals("bool") )
            throw new simpLanPlusError("TypeCheck Error: condition must be boolean.");

        sem_an.Environment tmp = new sem_an.Environment(e);
        for(Node n: then_node_statements) {
            n.typeCheck(e);
        }
        if(else_node_statements != null) {
            for (Node n : else_node_statements) {
                n.typeCheck(tmp);
            }

            for(int i=0; i<e.getSymbolTable().getSize(); i++) {
                Hashtable<String, sem_an.SymbolTableEntry> tmp1 = e.getSymbolTable().get(i);
                Hashtable<String, SymbolTableEntry> tmp2 = tmp.getSymbolTable().get(i);
                for(String elem: tmp1.keySet()) {
                    if((tmp1.get(elem).getStatus() == sem_an.Status.INITIALIZED && tmp2.get(elem).getStatus() == sem_an.Status.DECLARED) || (tmp1.get(elem).getStatus() == sem_an.Status.DECLARED && tmp2.get(elem).getStatus() == sem_an.Status.INITIALIZED)) {
                        throw new simpLanPlusError("Assignment incompatibility between the then and else branch for variable "+tmp1.get(elem).getLabel());
                    }
                }
            }
        } else {
            e = tmp;
        }
        return null;
    }

    @Override
    public String printNode(String s) {
        return null;
    }

    @Override
    public String codeGeneration(sem_an.Environment e) {
        String lthen = SimpLanPluslib.newLabel();
        String lend = SimpLanPluslib.newLabel();

        String stmThen = "";
        for(Node stm: this.then_node_statements)
            stmThen = stmThen + stm.codeGeneration(e);

        String stmElse = "";
        for(Node stm: this.else_node_statements)
            stmElse = stmElse + stm.codeGeneration(e);


        return condition.codeGeneration(e) +
                "storei T1 1 \n" +
                "beq A0 T1 "+ lthen + "\n" +
                stmElse +
                "b " + lend + "\n" +
                lthen + ":\n" +
                stmThen +
                lend + ":\n" ;
    }

}
