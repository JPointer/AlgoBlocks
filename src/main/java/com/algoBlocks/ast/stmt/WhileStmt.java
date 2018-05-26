package com.algoBlocks.ast.stmt;

import com.algoBlocks.ast.Node;
import com.algoBlocks.ast.aux.BlockMeta;

import java.util.ArrayList;

public class WhileStmt extends Node {

    private BlockMeta blockMetaWhile;
    private BlockMeta blockMetaWhileOp;
    private Node condition;
    private ArrayList<Node> whileNodes;

    public WhileStmt(BlockMeta blockMetaWhile, BlockMeta blockMetaWhileOp,
                     Node condition, ArrayList<Node> whileNodes) {
        this.blockMetaWhile = blockMetaWhile;
        this.blockMetaWhileOp = blockMetaWhileOp;
        this.condition = condition;
        this.whileNodes = whileNodes;
    }

    @Override
    public String toString() {
        return "WhileStmt{" +
                "blockMetaWhile=" + blockMetaWhile +
                ", blockMetaWhileOp=" + blockMetaWhileOp +
                '}';
    }


    @Override
    public ArrayList<? extends Node> getChildren() {
        ArrayList<Node> list = new ArrayList<Node>();
        list.add(condition);
        if(whileNodes != null)
            list.addAll(whileNodes);
        return list;
    }

    public BlockMeta getBlockMetaWhile() {
        return blockMetaWhile;
    }

    public BlockMeta getBlockMetaWhileOp() {
        return blockMetaWhileOp;
    }

    public Node getCondition() {
        return condition;
    }

    public ArrayList<Node> getWhileNodes() {
        return whileNodes;
    }
}
