package com.algoBlocks.ast.stmt;

import com.algoBlocks.ast.Node;
import com.algoBlocks.ast.aux.BlockMeta;

import java.util.ArrayList;

public class AssignmentStmt extends Node {

    private BlockMeta blockMeta;
    private String varName;
    private Node expr;

    public AssignmentStmt(BlockMeta blockMeta, String varName, Node expr) {
        this.blockMeta = blockMeta;
        this.varName = varName;
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "AssignmentStmt{" +
                "blockMeta=" + blockMeta +
                ", varName='" + varName + '\'' +
                '}';
    }

    @Override
    public ArrayList<? extends Node> getChildren() {
        ArrayList<Node> list = new ArrayList<Node>();
        list.add(expr);
        return list;
    }
}