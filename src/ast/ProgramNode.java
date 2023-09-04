package ast;

import simpLanPlusLib.SimpLanPluslib;
import sem_an.Environment;
import sem_an.SemanticError;

import java.util.ArrayList;

    public class ProgramNode implements Node {

        private ArrayList<Node> declarations;
        private ArrayList<Node> statements;

        private Node exp;
        private Environment env;

        public ProgramNode(ArrayList<Node> declarations, ArrayList<Node> statements, Node exp) {
            this.declarations = declarations;
            this.statements = statements;
            this.exp = exp;
        }

        public ProgramNode(Node exp) {
            this.exp = exp;
        }

        @Override
        public String printNode(String indent) {
            String res = "";
            if (this.declarations != null) {
                for (Node dec : declarations) {
                    res += dec.printNode(indent + " ");
                }
            }
            if (this.statements != null) {
                for (Node dec : statements) {
                    res += dec.printNode(indent + " ");
                }
            }

            if(this.exp != null) {
                res += exp.printNode(indent+ " ");
            }
            return "\n" + "Program" + res;
        }

        @Override
        public String codeGeneration(Environment e)
        {
            String decCode="";
            if (declarations != null)
                for (Node d: declarations)
                    decCode += d.codeGeneration(e);

            String stmCode="";
            if(statements != null)
                for (Node s: statements)
                    stmCode += s.codeGeneration(e);
            return  "move SP FP \n"
                    + "pushr FP \n"
                    + "move SP AL \n"
                    + "pushr AL \n"
                    + decCode
                    + stmCode
                    + (exp != null ? exp.codeGeneration(e) : "")
                    + "halt\n" +
                    SimpLanPluslib.getCode();
        }

        @Override
        public ArrayList<SemanticError> checkSemantics(Environment e) {
            this.env = e;
            this.env.getSymbolTable().enterInNewBlock();
            ArrayList<SemanticError> result = new ArrayList<SemanticError>();

            if (this.declarations != null && this.declarations.size() > 0) {
                for (Node n : this.declarations) {
                    result.addAll(n.checkSemantics(env));
                }
            }


            if (this.statements != null && this.statements.size() > 0) {
                for (Node n : this.statements) {
                    result.addAll(n.checkSemantics(env));
                }
            }

            if(this.exp != null) {
                result.addAll(exp.checkSemantics(env));
            }
            return result;
        }

        @Override
        public TypeNode typeCheck(Environment e) {
            if (this.declarations != null) {
                for (Node declaration : this.declarations) {
                    declaration.typeCheck(e);
                }
            }
            if (this.statements != null) {
                for (Node statement : this.statements) {
                    statement.typeCheck(e);
                }
            }
            return this.exp!=null? exp.typeCheck(e):null;
        }


    }
