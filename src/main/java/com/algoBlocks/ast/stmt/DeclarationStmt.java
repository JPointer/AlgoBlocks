package com.algoBlocks.ast.stmt;

import com.algoBlocks.ast.Node;
import com.algoBlocks.ast.aux.BlockMeta;

import java.util.ArrayList;

public class DeclarationStmt extends Node {

    private BlockMeta blockMeta;
    private String varName;
    private Node expr;

    public DeclarationStmt(BlockMeta blockMeta, String varName, Node expr) {
        this.blockMeta = blockMeta;
        this.varName = varName;
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "DeclarationStmt{" +
                "blockMeta=" + blockMeta +
                ", varName='" + varName + '\'' +
                '}';
    }

    @Override
    public ArrayList<? extends Node> getChildren() {
        ArrayList<Node> list = new ArrayList<Node>();
        if(expr != null)
            list.add(expr);
        return list;
    }

    public BlockMeta getBlockMeta() {
        return blockMeta;
    }

    public String getVarName() {
        return varName;
    }

    public Node getExpr() {
        return expr;
    }
}
