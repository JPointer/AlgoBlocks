package com.algoBlocks.ast.expr;

import com.algoBlocks.ast.Node;
import com.algoBlocks.ast.aux.MulOperand;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MulExpr extends Node {

    private ArrayList<MulOperand> operands;

    public MulExpr(ArrayList<MulOperand> operands) {
        this.operands = operands;
    }

    @Override
    public String toString() {
        return "MulExpr{}";
    }

    @Override
    public ArrayList<? extends Node> getChildren() {
        return operands.stream().map(MulOperand::getOperand).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<MulOperand> getOperands() {
        return operands;
    }
}
