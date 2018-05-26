package com.algoBlocks.ast.aux;

import com.algoBlocks.ast.Node;

public class AddOperand {

    private Node operand;
    private AddOp addOp;

    public AddOperand(Node operand, AddOp addOp) {
        this.operand = operand;
        this.addOp = addOp;
    }

    public Node getOperand() {return operand;}

    public AddOp getAddOp() {
        return addOp;
    }
}
