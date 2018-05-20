package com.algoBlocks.ast;

import com.algoBlocks.ast.atom.FuncCallAtom;
import com.algoBlocks.ast.atom.IntAtom;
import com.algoBlocks.ast.atom.NameAtom;
import com.algoBlocks.ast.aux.*;
import com.algoBlocks.ast.expr.*;
import parser.AlgoBlocksParser;

import java.util.ArrayList;

public class ExpressionAnalyzer {

    private Node expression;

    public void processExpression(AlgoBlocksParser.OrExprContext ctx) {
            expression = doOrExpr(ctx);
    }

    public Node getExpression() {
        return expression;
    }

    private Node doOrExpr(AlgoBlocksParser.OrExprContext ctx) {
        ArrayList<Node> operands = new ArrayList<Node>();

        if(ctx.andExpr().size() > 1) {
            for(AlgoBlocksParser.AndExprContext c : ctx.andExpr()) {
                operands.add(doAndExpr(c));
            }
        }
        else {
            return doAndExpr(ctx.andExpr(0));
        }
        return new OrExpr(operands);
    }
    private Node doAndExpr(AlgoBlocksParser.AndExprContext ctx) {
        ArrayList<Node> operands = new ArrayList<Node>();

        if(ctx.notExpr().size() > 1) {
            for(AlgoBlocksParser.NotExprContext c : ctx.notExpr()) {
                operands.add(doNotExpr(c));
            }
        }
        else {
            return doNotExpr(ctx.notExpr(0));
        }
        return new AndExpr(operands);
    }
    private Node doNotExpr(AlgoBlocksParser.NotExprContext ctx) {
        if(ctx.getText().startsWith("!")) {
            return new NotExpr(doEqExpr(ctx.eqExpr()));
        }
        return doEqExpr(ctx.eqExpr());
    }
    private Node doEqExpr(AlgoBlocksParser.EqExprContext ctx) {
        if(ctx.relExpr().size() == 2) {
            Node left = doRelExpr(ctx.relExpr(0));
            Node right = doRelExpr(ctx.relExpr(1));
            EqOp operator = null;

            if(ctx.EqOp().getText().equals("=="))
                operator = EqOp.EQ;
            else operator = EqOp.NEQ;

            return new EqExpr(left, right, operator);
        }
        return doRelExpr(ctx.relExpr(0));
    }
    private Node doRelExpr(AlgoBlocksParser.RelExprContext ctx) {
        if(ctx.addExpr().size() == 2) {
            Node left = doAddExpr(ctx.addExpr(0));
            Node right = doAddExpr(ctx.addExpr(1));
            RelOp operator = null;
            String opStr = ctx.RelOp().getText();

            if(opStr.equals("<"))
                operator = RelOp.LT;
            else if(opStr.equals("<="))
                operator = RelOp.LE;
            else if(opStr.equals(">"))
                operator = RelOp.GT;
            else
                operator = RelOp.GE;


            return new RelExpr(left, right, operator);
        }
        return doAddExpr(ctx.addExpr(0));
    }
    private Node doAddExpr(AlgoBlocksParser.AddExprContext ctx) {
        int n = ctx.mulExpr().size();
        if(n >1) {
            ArrayList<AddOperand> addOperands =  new ArrayList<AddOperand>();
            addOperands.add(new AddOperand(doMulExpr(ctx.mulExpr(0)), AddOp.PLUS));

            for(int i = 1; i < n; i++) {
                AddOp op = null;
                if(ctx.AddOp(i-1).getText().equals("+"))
                    op = AddOp.PLUS;
                else op = AddOp.MINUS;
                addOperands.add(new AddOperand(doMulExpr(ctx.mulExpr(i)), op));
            }
            return new AddExpr(addOperands);
        }
        return doMulExpr(ctx.mulExpr(0));
    }
    private Node doMulExpr(AlgoBlocksParser.MulExprContext ctx) {
        int n = ctx.atom().size();
        if(n >1) {
            ArrayList<MulOperand> mulOperands =  new ArrayList<MulOperand>();
            mulOperands.add(new MulOperand(doAtom(ctx.atom(0)), MulOp.MUL));

            for(int i = 1; i < n; i++) {
                MulOp op = null;
                String opStr = ctx.MulOp(i-1).getText();

                if(opStr.equals("*"))
                    op = MulOp.MUL;
                else if(opStr.equals("/"))
                    op = MulOp.DIV;
                else op = MulOp.MOD;

                mulOperands.add(new MulOperand(doAtom(ctx.atom(i)), op));
            }
            return new MulExpr(mulOperands);
        }
        return doAtom(ctx.atom(0));
    }
    private Node doAtom(AlgoBlocksParser.AtomContext ctx) {
        if(ctx.Int() != null)
            return new IntAtom(Integer.parseInt(ctx.Int().getText()));
        if(ctx.Name() != null)
            return new NameAtom(ctx.Name().getText());
        if(ctx.funcCall() != null)
            return doFuncCall(ctx.funcCall());

        return doOrExpr(ctx.orExpr());
    }
    private Node doFuncCall(AlgoBlocksParser.FuncCallContext ctx) {
        String name = ctx.Name().getText();
        ArrayList<Node> expressions = new ArrayList<Node>();
        if(ctx.argList() != null) {
            for(AlgoBlocksParser.OrExprContext e : ctx.argList().orExpr())
                expressions.add(doOrExpr(e));
        }
        return new FuncCallAtom(expressions, name);
    }
}


