package com.algoBlocks.interpreter;

import com.algoBlocks.listeners.ProgramListener;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.AlgoBlocksLexer;
import parser.AlgoBlocksParser;

import java.io.IOException;

public class Interpreter {

    public void parserTest() {
        CharStream stream = null;
        try{
            stream =new ANTLRFileStream("test/test3.c");
        }catch(IOException e){
            e.printStackTrace();
        }
        AlgoBlocksLexer lexer = new AlgoBlocksLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AlgoBlocksParser parser = new AlgoBlocksParser(tokens);
        AlgoBlocksParser.ProgramContext tree = parser.program();

        ProgramListener programListener = new ProgramListener();
        ParseTreeWalker.DEFAULT.walk(programListener, tree);

        System.out.println(programListener.getAst().toString());
    }
}
