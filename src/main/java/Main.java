import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.AlgoBlocksLexer;
import parser.AlgoBlocksParser;

import java.io.IOException;

public class Main {
    public static void main(String[] strs) {
        CharStream stream = null;
        try{
            stream =new ANTLRFileStream("test/test1.c");
        }catch(IOException e){
            e.printStackTrace();
        }
        AlgoBlocksLexer lexer = new AlgoBlocksLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AlgoBlocksParser parser = new AlgoBlocksParser(tokens);
        AlgoBlocksParser.ProgramContext tree = parser.program();

        ParseTreeWalker.DEFAULT.walk(new MyListener(), tree);
    }//to main
}//to Main
