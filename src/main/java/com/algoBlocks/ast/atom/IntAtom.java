package com.algoBlocks.ast.atom;

import com.algoBlocks.ast.Node;

import java.util.ArrayList;

public class IntAtom extends Node {

    private int value;

    public IntAtom(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IntAtom{" +
                "value=" + value +
                '}';
    }

    @Override
    public ArrayList<? extends Node> getChildren() {
        return super.getChildren();
    }

    public int getValue() {
        return value;
    }
}
