package com.algoBlocks.ast;

import com.algoBlocks.ast.aux.BlockMeta;

import java.util.ArrayList;

public class FunDef extends Node {

    private BlockMeta blockMeta;
    private String name;
    private ArrayList<String> params;
    private ArrayList<Node> operations;
    private Node retStmt;

    public FunDef(BlockMeta blockMeta, String name, ArrayList<String> params,
                  ArrayList<Node> operations, Node retStmt) {
        this.blockMeta = blockMeta;
        this.name = name;
        this.params = params;
        this.operations = operations;
        this.retStmt = retStmt;
    }

    @Override
    public String toString() {
        return "FunDef{" +
                "blockMeta=" + blockMeta +
                ", name='" + name + '\'' +
                ", params=" + params +
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
}
