package com.algoBlocks.ast.stmt;

import com.algoBlocks.ast.Node;
import com.algoBlocks.ast.aux.BlockMeta;

import java.util.ArrayList;

public class WriteStmt extends Node {

    private BlockMeta blockMeta;
    private ArrayList<String> varNames;

    public WriteStmt(BlockMeta blockMeta, ArrayList<String> varNames) {
        this.blockMeta = blockMeta;
        this.varNames = varNames;
    }

    @Override
    public String toString() {
        return "WriteStmt{" +
                "blockMeta=" + blockMeta +
                ", varNames=" + varNames +
                '}';
    }

    @Override
    public ArrayList<? extends Node> getChildren() {
        return super.getChildren();
    }
}
