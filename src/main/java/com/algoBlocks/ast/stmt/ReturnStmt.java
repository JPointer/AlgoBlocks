package com.algoBlocks.ast.stmt;

import com.algoBlocks.ast.Node;
import com.algoBlocks.ast.aux.BlockMeta;

import java.util.ArrayList;

public class ReturnStmt extends Node {

    private BlockMeta blockMeta;
    private Node ret;

    public ReturnStmt(BlockMeta blockMeta, Node ret) {
        this.blockMeta = blockMeta;
        this.ret = ret;
    }

    @Override
    public String toString() {
        return "ReturnStmt{" +
                "blockMeta=" + blockMeta +
                '}';
    }
    @Override
    public ArrayList<? extends Node> getChildren() {
        ArrayList<Node> list = new ArrayList<Node>();
        list.add(ret);
        return list;
    }
}
