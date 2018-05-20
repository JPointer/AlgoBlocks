package com.algoBlocks.ast.atom;

import com.algoBlocks.ast.Node;

import java.util.ArrayList;

public class FuncCallAtom extends Node {

    private ArrayList<Node> params;
    private String funcName;

    public FuncCallAtom(ArrayList<Node> params, String funcName) {
        this.params = params;
        this.funcName = funcName;
    }

    @Override
    public String toString() {
        return "FuncCallAtom{" +
                "funcName='" + funcName + '\'' +
                '}';
    }

    @Override
    public ArrayList<? extends Node> getChildren() {
        return params;
    }
}
