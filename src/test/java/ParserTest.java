import com.algoBlocks.listeners.ProgramListener;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import parser.AlgoBlocksLexer;
import parser.AlgoBlocksParser;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class ParserTest {

    @Test
    public void parserTest() {
        CharStream stream = null;
        try{
            stream =new ANTLRFileStream("test/test4.c");
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

        System.out.println(programListener.getAst().toString());
        assertTrue(true);
    }
}
