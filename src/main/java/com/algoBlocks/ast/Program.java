package com.algoBlocks.ast;

import java.util.ArrayList;

public class Program extends Node {

    private ArrayList<Node> funDefs;
    private Node mainNode;

    public Program(ArrayList<Node> funDefs, Node mainNode) {
        this.funDefs = funDefs;
        this.mainNode = mainNode;
    }

    @Override
    public ArrayList<? extends Node> getChildren() {
        ArrayList<Node> list = new ArrayList<Node>();
        if(funDefs != null)
            list.addAll(funDefs);
        list.add(mainNode);
        return list;
    }
}
