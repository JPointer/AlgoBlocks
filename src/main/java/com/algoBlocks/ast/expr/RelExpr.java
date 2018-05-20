package com.algoBlocks.ast.expr;

import com.algoBlocks.ast.Node;
import com.algoBlocks.ast.aux.RelOp;

import java.util.ArrayList;

public class RelExpr extends Node {

    private Node left;
    private  Node right;
    private RelOp relOp;

    public RelExpr(Node left, Node right, RelOp relOp) {
        this.left = left;
        this.right = right;
        this.relOp = relOp;
    }

    @Override
    public String toString() {
        return "RelExpr{}";
    }

    @Override
    public ArrayList<? extends Node> getChildren() {
        ArrayList<Node> list = new ArrayList<Node>();
        list.add(left);
        list.add(right);
        return list;
    }
}
