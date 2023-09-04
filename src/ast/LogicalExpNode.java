package ast;

import simpLanPlusLib.SimpLanPluslib;
import sem_an.Environment;
import sem_an.simpLanPlusError;
import sem_an.SemanticError;

import java.util.ArrayList;

public class LogicalExpNode implements Node{

    Node e1;
    Node e2;
    String op;

    public LogicalExpNode(Node e1, String op, Node e2) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }
    @Override
    public ArrayList<SemanticError> checkSemantics(Environment e) {
        ArrayList<SemanticError> result = new ArrayList<SemanticError>();
        if (this.e1 != null) {
            result.addAll(e1.checkSemantics(e));
        }
        if (this.e2 != null) {
            result.addAll(e2.checkSemantics(e));
        }
        return result;
    }

    @Override
    public TypeNode typeCheck(Environment e) throws Error {
        if(!e1.typeCheck(e).getType().equals("bool") || !e2.typeCheck(e).getType().equals("bool")){
            throw new simpLanPlusError("TypeChecking Error: this operation doesn't allow variables of this type.");
        }
        return new TypeNode("bool");
    }

    @Override
    public String printNode(String s) {
        return e1.printNode(s)+op+e2.printNode(s);
    }

    @Override
    public String codeGeneration(Environment e) {


        String result;
        if (op.equals("&&")) {
            String lend = SimpLanPluslib.newLabel();
            result = e1.codeGeneration(e)+
                    "push 0 \n"+
                    "popr T1 \n"+
                    "beq A0 T1 "+lend+"\n"+
                    e2.codeGeneration(e)+
                    lend+ ":\n";
        } else {
            String trueL = SimpLanPluslib.newLabel();
            String lend = SimpLanPluslib.newLabel();
            result = e1.codeGeneration(e)+
                    "pushr A0 \n" +
                    e2.codeGeneration(e)+
                    "popr T1 \n" +
                    "add A0 T1 \n"+
                    "popr A0 \n"+
                    "push 1 \n"+
                    "popr T1 \n"+
                    "bgte A0 T1 "+trueL+"\n"+
                    "push 0 \n"+
                    "popr A0 \n"+
                    "b "+lend+"\n"+
                     trueL+ ":\n" +
                    "push 1 \n"+
                    "popr A0 \n"+
                    lend+ ":\n";
        }


        return result;
    }
}
