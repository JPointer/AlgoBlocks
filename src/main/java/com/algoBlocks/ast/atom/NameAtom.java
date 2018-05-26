package com.algoBlocks.ast.atom;

import com.algoBlocks.ast.Node;

import java.util.ArrayList;

public class NameAtom extends Node {

    private String name;

    public NameAtom(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NameAtom{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public ArrayList<? extends Node> getChildren() {
        return super.getChildren();
    }

    public String getName() {
        return name;
    }
}
