package com.algoBlocks.ast;

import com.algoBlocks.ast.aux.BlockMeta;
import com.algoBlocks.ast.stmt.*;
import parser.AlgoBlocksParser;

import java.util.ArrayList;

public class StatementsAnalyzer {

    private ArrayList<Node> statements = new ArrayList<Node>();

    public void processStatementList(AlgoBlocksParser.StatementListContext ctx) {
        ctx.statement().forEach(s -> process(s));
    }

    public ArrayList<Node> getStatements() {
        return statements;
    }

    private ArrayList<Node> doStatementList(AlgoBlocksParser.StatementListContext ctx) {
        StatementsAnalyzer statementsAnalyzer = new StatementsAnalyzer();

        ctx.statement().forEach(s -> statementsAnalyzer.process(s));

        return statementsAnalyzer.getStatements();

    }
    private void process(AlgoBlocksParser.StatementContext ctx) {
        if(ctx.ifStmt() != null) {
            doIfStmt(ctx.ifStmt());
        }
        else if(ctx.assignmentStmt() != null) {
            doAssignmentStmt(ctx.assignmentStmt());
        }
        else if(ctx.declarationStmt() != null) {
            doDeclarationStmt(ctx.declarationStmt());
        }
        else if(ctx.readStmt() != null) {
            doReadStmt(ctx.readStmt());
        }
        else if(ctx.writeStmt() != null) {
            doWriteStmt(ctx.writeStmt());
        }
        else if(ctx.whileStmt() != null) {
            doWhileStmt(ctx.whileStmt());
        }
    }

    private void doIfStmt(AlgoBlocksParser.IfStmtContext ifStmtContext) {
        BlockMeta blockMetaCondition = new BlockMeta(ifStmtContext.ifAnn().annBody(0),"IF");

        ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
        expressionAnalyzer.processExpression(ifStmtContext.orExpr());
        Node condition = expressionAnalyzer.getExpression();

        BlockMeta blockMetaTrue = new BlockMeta(ifStmtContext.ifAnn().annBody(1),"TRUE");
        ArrayList<Node> trueNodes = null;
        if(ifStmtContext.trueList != null){
            trueNodes = doStatementList(ifStmtContext.trueList);
        }

        BlockMeta blockMetaFalse = null;
        ArrayList<Node> falseNodes = null;
        if(ifStmtContext.ifAnn().annBody(2) != null) {
            blockMetaFalse = new BlockMeta(ifStmtContext.ifAnn().annBody(2), "ELSE");
            if(ifStmtContext.elseList != null)
                falseNodes = doStatementList(ifStmtContext.elseList);
        }

        IfStmt ifStmt = new IfStmt(blockMetaCondition, condition,
                blockMetaTrue, trueNodes,
                blockMetaFalse, falseNodes);
        statements.add(ifStmt);
    }

    private void doAssignmentStmt(AlgoBlocksParser.AssignmentStmtContext assignmentStmtContext) {
        BlockMeta blockMeta = new BlockMeta(assignmentStmtContext.assignAnn().annBody(), "ASSIGN");
        String name = new String(assignmentStmtContext.Name().getText());
        ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
        expressionAnalyzer.processExpression(assignmentStmtContext.orExpr());
        Node expr = expressionAnalyzer.getExpression();

        AssignmentStmt assignmentStmt = new AssignmentStmt(blockMeta, name, expr);
        statements.add(assignmentStmt);
    }

    private void doDeclarationStmt(AlgoBlocksParser.DeclarationStmtContext declarationStmtContext) {
        BlockMeta blockMeta = new BlockMeta(declarationStmtContext.declAnn().annBody(), "DECL");
        String name = new String(declarationStmtContext.Name().getText());
        Node expr = null;
        if(declarationStmtContext.orExpr() != null) {
            ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
            expressionAnalyzer.processExpression(declarationStmtContext.orExpr());
            expr = expressionAnalyzer.getExpression();
        }
        DeclarationStmt declarationStmt = new DeclarationStmt(blockMeta, name, expr);
        statements.add(declarationStmt);
    }

    private void doReadStmt(AlgoBlocksParser.ReadStmtContext readStmtContext) {
        BlockMeta blockMeta = new BlockMeta(readStmtContext.readAnn().annBody(), "READ");
        String name = new String(readStmtContext.Name().getText());

        ReadStmt readStmt = new ReadStmt(blockMeta, name);
        statements.add(readStmt);
    }

    private void doWriteStmt(AlgoBlocksParser.WriteStmtContext writeStmtContext) {
        BlockMeta blockMeta = new BlockMeta(writeStmtContext.writeAnn().annBody(), "WRITE");
        ArrayList<String> varNames = new ArrayList<String>();
        writeStmtContext.writeParams().Name().forEach(n -> varNames.add(new String(n.getText())));

        WriteStmt writeStmt = new WriteStmt(blockMeta, varNames);
        statements.add(writeStmt);
    }

    private void doWhileStmt(AlgoBlocksParser.WhileStmtContext whileStmtContext) {
        BlockMeta blockMetaWhile = new BlockMeta(whileStmtContext.whileAnn().annBody(0),"WHILE");
        BlockMeta blockMetaWhileOp = new BlockMeta(whileStmtContext.whileAnn().annBody(1),"WHILEOP");

        ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
        expressionAnalyzer.processExpression(whileStmtContext.orExpr());

        Node condition = expressionAnalyzer.getExpression();

        ArrayList<Node> whileNodes = null;
        if(whileStmtContext.statementList() != null){
            whileNodes = doStatementList(whileStmtContext.statementList());
        }

        WhileStmt whileStmt = new WhileStmt(blockMetaWhile, blockMetaWhileOp, condition, whileNodes);
        statements.add(whileStmt);
    }
}
