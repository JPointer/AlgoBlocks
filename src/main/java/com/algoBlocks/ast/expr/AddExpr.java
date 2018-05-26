package com.algoBlocks.ast.expr;

import com.algoBlocks.ast.Node;
import com.algoBlocks.ast.aux.AddOperand;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AddExpr extends Node {

    private ArrayList<AddOperand> operands;

    public AddExpr(ArrayList<AddOperand> operands) {
        this.operands = operands;
    }

    @Override
    public String toString() {
        return "AddExpr";
    }

    @Override
    public ArrayList<? extends Node> getChildren() {
        return operands.stream().map(AddOperand::getOperand).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<AddOperand> getOperands() {
        return operands;
    }
}
