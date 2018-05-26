package com.algoBlocks.ast.expr;

import com.algoBlocks.ast.Node;
import com.algoBlocks.ast.aux.EqOp;

import java.util.ArrayList;

public class EqExpr extends Node {

    private Node left;
    private  Node right;
    private EqOp eqOp;

    public EqExpr(Node left, Node right, EqOp eqOp) {
        this.left = left;
        this.right = right;
        this.eqOp = eqOp;
    }
    @Override
    public String toString() {
        return "EqExpr";
    }

    @Override
    public ArrayList<? extends Node> getChildren() {
        ArrayList<Node> list = new ArrayList<Node>();
        list.add(left);
        list.add(right);
        return list;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public EqOp getEqOp() {
        return eqOp;
    }
}
