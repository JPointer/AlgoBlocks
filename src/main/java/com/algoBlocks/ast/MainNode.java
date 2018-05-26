package com.algoBlocks.ast;

import com.algoBlocks.ast.aux.BlockMeta;

import java.util.ArrayList;

public class MainNode extends Node {

    private BlockMeta blockMeta;
    private ArrayList<Node> operations;
    private Node retStmt;

    public MainNode(BlockMeta blockMeta, ArrayList<Node> operations, Node retStmt) {
        this.blockMeta = blockMeta;
        this.operations = operations;
        this.retStmt = retStmt;
    }

    @Override
    public String toString() {
        return "MainNode{" +
                "blockMeta=" + blockMeta +
                '}';
    }

    @Override
    public ArrayList<? extends Node> getChildren() {
        ArrayList<Node> list = new ArrayList<Node>();
        if(operations != null)
            list.addAll(operations);
        list.add(retStmt);
        return list;
    }

    public BlockMeta getBlockMeta() {
        return blockMeta;
    }

    public ArrayList<Node> getOperations() {
        return operations;
    }

    public Node getRetStmt() {
        return retStmt;
    }
}
