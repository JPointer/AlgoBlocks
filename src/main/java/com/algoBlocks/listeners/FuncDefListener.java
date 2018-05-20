package com.algoBlocks.listeners;

import com.algoBlocks.ast.ExpressionAnalyzer;
import com.algoBlocks.ast.FunDef;
import com.algoBlocks.ast.Node;
import com.algoBlocks.ast.StatementsAnalyzer;
import com.algoBlocks.ast.aux.BlockMeta;
import com.algoBlocks.ast.stmt.ReturnStmt;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.AlgoBlocksBaseListener;
import parser.AlgoBlocksParser;

import java.util.ArrayList;

public class FuncDefListener extends AlgoBlocksBaseListener {

    private ArrayList<Node> retNodes = new ArrayList<Node>();

    @Override
    public void enterFuncDef(AlgoBlocksParser.FuncDefContext ctx) {

        BlockMeta blockMeta = new BlockMeta(ctx.funcAnn().annBody(), "FUNC");
        String name = new String(ctx.Name().getText());

        ArrayList<String> params = new ArrayList<String>();
        for(TerminalNode t : ctx.parameterList().Name()) {
            params.add(new String(t.getText()));
        }
        ArrayList<Node> operations = null;
        StatementsAnalyzer statementsAnalyzer = new StatementsAnalyzer();
        if(ctx.statementList() != null) {
            statementsAnalyzer.processStatementList(ctx.statementList());
            operations = statementsAnalyzer.getStatements();
        }

        BlockMeta returnMeta = new BlockMeta(ctx.returnStmt().retAnn().annBody(), "RET");
        ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
        expressionAnalyzer.processExpression(ctx.returnStmt().orExpr());
        Node retExpr = expressionAnalyzer.getExpression();
        ReturnStmt retStmt = new ReturnStmt(returnMeta, retExpr);
        retNodes.add(new FunDef(blockMeta, name, params, operations, retStmt));
    }

    public ArrayList<Node> getRetNodes() {
        return retNodes;
    }
}
