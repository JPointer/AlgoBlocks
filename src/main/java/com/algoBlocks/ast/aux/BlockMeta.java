package com.algoBlocks.ast.aux;

import parser.AlgoBlocksParser;

public class BlockMeta {

    private String name;
    private int x;
    private int y;
    private int w;
    private int h;
    private int p;

    public BlockMeta(AlgoBlocksParser.AnnBodyContext annBodyContext, String name) {
        this.x = Integer.parseInt(annBodyContext.xVal().Int().getText());
        this.y = Integer.parseInt(annBodyContext.yVal().Int().getText());
        this.w = Integer.parseInt(annBodyContext.wVal().Int().getText());
        this.h = Integer.parseInt(annBodyContext.hVal().Int().getText());
        this.p = Integer.parseInt(annBodyContext.pVal().Int().getText());
        this.name = name;
    }

    @Override
    public String toString() {
        return "BlockMeta{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                ", p=" + p +
                '}';
    }
}
