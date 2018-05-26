package com.algoBlocks.ast.expr;

import com.algoBlocks.ast.Node;

import java.util.ArrayList;

public class NotExpr extends Node {

    private Node operand;

    public NotExpr(Node operand) {
        this.operand = operand;
    }

    @Override
    public String toString() {
        return "NotExpr{}";
    }

    @Override
    public ArrayList<? extends Node> getChildren() {
        ArrayList<Node> list = new ArrayList<Node>();
        list.add(operand);
        return list;
    }

    public Node getOperand() {
        return operand;
    }
}
