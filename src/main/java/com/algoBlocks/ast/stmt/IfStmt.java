package com.algoBlocks.ast.stmt;

import com.algoBlocks.ast.Node;
import com.algoBlocks.ast.aux.BlockMeta;

import java.util.ArrayList;

public class IfStmt extends Node {

    private BlockMeta blockMetaCondition;
    private Node condition;

    private BlockMeta blockMetaTrue;
    private ArrayList<Node> trueNodes;

    private BlockMeta blockMetaFalse;
    private ArrayList<Node> falseNodes;

    public IfStmt(BlockMeta blockMetaCondition, Node condition,
                  BlockMeta blockMetaTrue, ArrayList<Node> trueNodes,
                  BlockMeta blockMetaFalse, ArrayList<Node> falseNodes) {
        this.blockMetaCondition = blockMetaCondition;
        this.condition = condition;
        this.blockMetaTrue = blockMetaTrue;
        this.trueNodes = trueNodes;
        this.blockMetaFalse = blockMetaFalse;
        this.falseNodes = falseNodes;
    }

    @Override
    public String toString() {
        return "IfStmt{" +
                "blockMetaCondition=" + blockMetaCondition +
                ", blockMetaTrue=" + blockMetaTrue +
                ", blockMetaFalse=" + blockMetaFalse +
                '}';
    }

    @Override
    public ArrayList<? extends Node> getChildren() {
        ArrayList<Node> list = new ArrayList<Node>();
        list.add(condition);
        if(trueNodes != null)
            list.addAll(trueNodes);
        if(falseNodes != null)
            list.addAll(falseNodes);
        return list;
    }
}
