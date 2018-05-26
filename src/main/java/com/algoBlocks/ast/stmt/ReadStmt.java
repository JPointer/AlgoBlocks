package com.algoBlocks.ast.stmt;

import com.algoBlocks.ast.Node;
import com.algoBlocks.ast.aux.BlockMeta;

import java.util.ArrayList;

public class ReadStmt extends Node {

    private BlockMeta blockMeta;
    private String varName;

    public ReadStmt(BlockMeta blockMeta, String varName) {
        this.blockMeta = blockMeta;
        this.varName = varName;
    }

    @Override
    public String toString() {
        return "ReadStmt{" +
                "blockMeta=" + blockMeta +
                ", varName='" + varName + '\'' +
                '}';
    }

    @Override
    public ArrayList<? extends Node> getChildren() {
        return super.getChildren();
    }

    public BlockMeta getBlockMeta() {
        return blockMeta;
    }

    public String getVarName() {
        return varName;
    }
}
