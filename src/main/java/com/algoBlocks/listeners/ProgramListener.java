package com.algoBlocks.listeners;

import com.algoBlocks.ast.*;
import com.algoBlocks.ast.aux.BlockMeta;
import com.algoBlocks.ast.stmt.ReturnStmt;
import parser.AlgoBlocksBaseListener;
import parser.AlgoBlocksParser;

import java.util.ArrayList;
import java.util.List;

public class ProgramListener extends AlgoBlocksBaseListener {

    private Ast ast;

    @Override
    public void enterProgram(AlgoBlocksParser.ProgramContext ctx) {
        FuncDefListener funcDefListener = new FuncDefListener();
        ctx.funcDef().forEach(f -> f.enterRule(funcDefListener));

        ArrayList<Node> funDefs = funcDefListener.getRetNodes();

        BlockMeta blockMeta = new BlockMeta(ctx.mainFunc().mainAnn().annBody(), "MAIN");
        StatementsAnalyzer statementsAnalizer = new StatementsAnalyzer();
        ArrayList<Node> statements = null;

        if(ctx.mainFunc().statementList() != null) {
            statementsAnalizer.processStatementList(ctx.mainFunc().statementList());
            statements = statementsAnalizer.getStatements();
        }

        BlockMeta returnMeta = new BlockMeta(ctx.mainFunc().returnStmt().retAnn().annBody(), "RET");
        ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
        expressionAnalyzer.processExpression(ctx.mainFunc().returnStmt().orExpr());
        Node retExpr = expressionAnalyzer.getExpression();
        ReturnStmt retStmt = new ReturnStmt(returnMeta, retExpr);

        MainNode mainNode = new MainNode(blockMeta, statements, retStmt);
        Program program = new Program(funDefs, mainNode);
        ast = new Ast(program);
    }

    public Ast getAst() {
        return ast;
    }
}