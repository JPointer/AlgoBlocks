package com.algoBlocks.ast.expr;

import com.algoBlocks.ast.Node;

import java.util.ArrayList;

public class AndExpr extends Node {

    private ArrayList<Node> operands;

    public AndExpr(ArrayList<Node> operands) {
        this.operands = operands;
    }

    @Override
    public String toString() {
        return "AndExpr";
    }

    @Override
    public ArrayList<? extends Node> getChildren() {
        return operands;
    }

    public ArrayList<Node> getOperands() {
        return operands;
    }
}
