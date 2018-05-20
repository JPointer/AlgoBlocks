package com.algoBlocks.ast.expr;

import com.algoBlocks.ast.Node;

import java.util.ArrayList;

public class OrExpr extends Node {

    private ArrayList<Node> operands;

    public OrExpr(ArrayList<Node> operands) {
        this.operands = operands;
    }

    @Override
    public String toString() {
        return "OrExpr{}";
    }

    @Override
    public ArrayList<? extends Node> getChildren() {
        return operands;
    }
}
