import ast.*;

import java.util.ArrayList;

public class Visitor extends SimpLanPlusBaseVisitor<Node>{
    public Visitor() {}
    public Node visitMultExp(SimpLanPlusParser.MultExpContext ctx) {
        System.out.println("visitMultExp");
        ArrayList<Node> declarations = new ArrayList<>();
        ArrayList<Node> statements = new ArrayList<>();

        Node exp;

        for (SimpLanPlusParser.DecContext dc : ctx.dec()){
            declarations.add(visit(dc));
        }

        if (ctx.stm() != null)
            for (SimpLanPlusParser.StmContext sm: ctx.stm()){
                statements.add(visit(sm));
            }

        if (ctx.exp() != null) {
            exp = visit(ctx.exp());
        } else {
            exp = null;
        }

        return new ProgramNode(declarations, statements, exp);
    }

    public Node visitSingleExp(SimpLanPlusParser.SingleExpContext ctx){
        System.out.println("visitSingleExp");
        Node exp;
        exp = visit(ctx.exp());
        return exp;
    }
    public Node visitVarDec(SimpLanPlusParser.VarDecContext ctx) {
        System.out.println("visitVarDec");

        TypeNode typeNode = (TypeNode) visit(ctx.type());

        return new DecNode(ctx.ID().getText(), typeNode);
    }

    public Node visitParam(SimpLanPlusParser.ParamContext ctx) {
        System.out.println("visitParam");

        TypeNode typeNode = (TypeNode) visit(ctx.type());

        return new ArgNode(typeNode,ctx.ID().getText());
    }

    public Node visitFunDec(SimpLanPlusParser.FunDecContext ctx) {
        System.out.println("visitFunctionDec");

        ArrayList<Node> param = new ArrayList<>() ;

        for (SimpLanPlusParser.ParamContext p : ctx.param())
            param.add(visit(p));

        ArrayList<Node> innerDecs = new ArrayList<Node>();
        ArrayList<Node> innerStatements = new ArrayList<Node>();
        Node innerExp;

        SimpLanPlusParser.BodyContext body = ctx.body();

        if(body.dec() != null)

            for(SimpLanPlusParser.DecContext dc : body.dec())
                innerDecs.add(visit(dc));


        if(body.stm() != null)
            for (SimpLanPlusParser.StmContext sm: body.stm()){
                innerStatements.add(visit(sm));
            }

        if (body.exp() != null) {
            innerExp = visit(body.exp());
        } else {
            innerExp = null;
        }

        return new DecFunctionNode(visit(ctx.type()), ctx.ID().getText(), param, innerDecs, innerStatements, innerExp);
    }

    public Node visitType(SimpLanPlusParser.TypeContext ctx) {
        System.out.println("visitType");
        return new TypeNode(ctx.getText());
    }

    public Node visitAsgStm(SimpLanPlusParser.AsgStmContext ctx) {
        System.out.println("visitAsgStm");
        return new AsgNode(ctx.ID().getText(), visit(ctx.exp()));
    }



    public Node visitIfStm(SimpLanPlusParser.IfStmContext ctx) {
        System.out.println("visitIfStm");

        SimpLanPlusParser.ThenStmBranchContext thenS = ctx.thenB;

        ArrayList<Node> innerThenStatements = new ArrayList<Node>();


        for(SimpLanPlusParser.StmContext sm: thenS.stm()){
            innerThenStatements.add(visit(sm));
        }

        SimpLanPlusParser.ElseStmBranchContext elseS = ctx.elseB;
        ArrayList<Node> innerElseDecs = new ArrayList<Node>();
        ArrayList<Node> innerElseStatements = new ArrayList<>();
        if(elseS != null){
            for(SimpLanPlusParser.StmContext sm: elseS.stm()){
                innerElseStatements.add(visit(sm));
            }
        }

        return new IfStmNode(visit(ctx.condition), innerThenStatements, innerElseStatements);
    }

    public Node visitIntExp(SimpLanPlusParser.IntExpContext ctx) {
        System.out.println("visitIntExp");
        return new IntNode(Integer.parseInt(ctx.getText()));
    }

    public Node visitTrueExp(SimpLanPlusParser.TrueExpContext ctx) {
        System.out.println("visitTrueExp");
        return new BoolNode(Boolean.parseBoolean(ctx.getText()));
    }

    public Node visitFalseExp(SimpLanPlusParser.FalseExpContext ctx) {
        System.out.println("visitFalseExp");
        return new BoolNode(Boolean.parseBoolean(ctx.getText()));
    }

    public Node visitIdExp(SimpLanPlusParser.IdExpContext ctx) {
        System.out.println("visitIdExp");
        return new IdNode(ctx.getText());
    }

    public Node visitNotIdExp(SimpLanPlusParser.NotIdExpContext ctx) {
        System.out.println("visitNotIdExp");
        return new NotExpNode(visit(ctx.exp()));
    }

    public Node visitMulDivExp(SimpLanPlusParser.MulDivExpContext ctx) {
        System.out.println("visitMulDivExp");
        return new MulDivNode(visit(ctx.e1), ctx.op.getText(), visit(ctx.e2));
    }

    public Node visitPlusMinusExp(SimpLanPlusParser.PlusMinusExpContext ctx) {
        System.out.println("visitPlusMinusExp");
        return new PlusMinusNode(visit(ctx.e1), ctx.op.getText(), visit(ctx.e2));
    }

    public Node visitCfrExp(SimpLanPlusParser.CfrExpContext ctx) {
        System.out.println("visitCfrExp");
        return new CfrExpNode(visit(ctx.e1),ctx.op.getText(), visit(ctx.e2));
    }

    public Node visitLogicalExp(SimpLanPlusParser.LogicalExpContext ctx) {
        System.out.println("visitLogicalExp");
        return new LogicalExpNode(visit(ctx.e1),ctx.op.getText(), visit(ctx.e2));
    }

    public Node visitIfExp(SimpLanPlusParser.IfExpContext ctx) {
        System.out.println("visitIfExp");

        SimpLanPlusParser.ThenExpBranchContext thenS = ctx.thenB;
        ArrayList<Node> innerThenDeclarations = new ArrayList<Node>();
        ArrayList<Node> innerThenStatements = new ArrayList<Node>();
        /*for(SimpLanPlusParser.DecContext dec : thenS.dec()){
            innerThenDeclarations.add(visit(dec));
        }*/
        for(SimpLanPlusParser.StmContext sm: thenS.stm()){
            innerThenStatements.add(visit(sm));
        }
        Node innerThenExp = visit(thenS.exp());

        SimpLanPlusParser.ElseExpBranchContext elseS = ctx.elseB;
        ArrayList<Node> innerElseDeclarations = new ArrayList<>();
        ArrayList<Node> innerElseStatements = new ArrayList<>();
        Node innerElseExp = null;
        if(elseS != null) {
            /*for(SimpLanPlusParser.DecContext sm: elseS.dec()){
                innerElseDeclarations.add(visit(sm));
            }*/
            for(SimpLanPlusParser.StmContext sm: elseS.stm()){
                innerElseStatements.add(visit(sm));
            }
            innerElseExp = visit(elseS.exp());
        }

        return new IfExpNode(visit(ctx.condition),innerThenDeclarations, innerThenStatements, innerThenExp, innerElseDeclarations ,innerElseStatements, innerElseExp);
    }

    public Node visitBracketExp(SimpLanPlusParser.BracketExpContext ctx) {
        System.out.println("visitBracketExp");
        return visit(ctx.exp());
    }

    public Node visitFunCallExp(SimpLanPlusParser.FunCallExpContext ctx) {

        System.out.println("visitFunctionCallExp");

        ArrayList<Node> params = new ArrayList<>();
        for(SimpLanPlusParser.ExpContext e: ctx.exp()) {
            params.add(visit(e));
        }
        return new FunctionCallNode(ctx.ID().getText(), params);
    }

    public Node visitFunCallStm(SimpLanPlusParser.FunCallStmContext ctx) {
        System.out.println("visitFunctionCallExp");

        ArrayList<Node> params = new ArrayList<>();
        for(SimpLanPlusParser.ExpContext e: ctx.exp()) {
            params.add(visit(e));
        }
        return new FunctionCallNode(ctx.ID().getText(), params);
    }

}
