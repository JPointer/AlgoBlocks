package com.algoBlocks.ast.aux;

public class Variable {

    private int value;
    private String name;

    public Variable(String name) {
        this.name = name;
        this.value = 0;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
