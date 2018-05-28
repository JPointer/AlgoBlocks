import com.algoBlocks.ast.Ast;
import com.algoBlocks.listeners.ProgramListener;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.AlgoBlocksLexer;
import parser.AlgoBlocksParser;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] strs) {
        CharStream stream = null;
        try{
            stream =new ANTLRFileStream("test/test8.c");
        }catch(IOException e){
            e.printStackTrace();
        }
        AlgoBlocksLexer lexer = new AlgoBlocksLexer(stream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AlgoBlocksParser parser = new AlgoBlocksParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);


        AlgoBlocksParser.ProgramContext tree = null;
        try {
            tree = parser.program();
        } catch (ParseCancellationException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        ProgramListener programListener = new ProgramListener();
        ParseTreeWalker.DEFAULT.walk(programListener, tree);

        Ast treeToExecute = programListener.getAst();

        Scanner in = new Scanner(System.in);
        int num = 1;
        System.out.println("Start executing press 1");
        num = in.nextInt();

        if(num != 1)
            return;

        try {
            treeToExecute.preExecuting();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        treeToExecute.execute();
    }//to main
}//to Main
