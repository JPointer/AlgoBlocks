package com.algoBlocks.ast.aux;

import com.algoBlocks.ast.Node;

public class MulOperand {

    private Node operand;
    private MulOp mulOp;

    public MulOperand(Node operand, MulOp mulOp) {
        this.operand = operand;
        this.mulOp = mulOp;
    }

    public Node getOperand() {return operand;}
}
