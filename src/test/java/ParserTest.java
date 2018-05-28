import com.algoBlocks.ast.Ast;
import com.algoBlocks.listeners.ProgramListener;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import parser.AlgoBlocksLexer;
import parser.AlgoBlocksParser;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParserTest {

    @Test
    public void parserTestReadingUndeclaredVariable() {
        Ast treeToExecute = null;
        try {
            treeToExecute = prepareAst("astfiles/test1.c");
            treeToExecute.preExecuting();
        } catch (Exception e) {
            assertEquals(e.getMessage(),"ERROR read: invalid b variable");
            return;
        }
    }

    @Test
    public void ParserTestOverrideVariableInMain() {
        Ast treeToExecute = null;
        try {
            treeToExecute = prepareAst("astfiles/test2.c");
            treeToExecute.preExecuting();
        } catch (Exception e) {
            assertEquals(e.getMessage(),"ERROR override a param");
            return;
        }
    }

    @Test
    public void ParserTestAssignUsingUndeclaredVariable() {
        Ast treeToExecute = null;
        try {
            treeToExecute = prepareAst("astfiles/test3.c");
            treeToExecute.preExecuting();
        } catch (Exception e) {
            assertEquals(e.getMessage(),"ERROR variable b not found");
            return;
        }
    }

    @Test
    public void ParserTestCallingFunctionNotExist() {
        Ast treeToExecute = null;
        try {
            treeToExecute = prepareAst("astfiles/test4.c");
            treeToExecute.preExecuting();
        } catch (Exception e) {
            assertEquals(e.getMessage(),"There is no function called: func");
            return;
        }
    }

    @Test
    public void ParserTestCallingFunctionWrongNumberOfArguments() {
        Ast treeToExecute = null;
        try {
            treeToExecute = prepareAst("astfiles/test5.c");
            treeToExecute.preExecuting();
        } catch (Exception e) {
            assertEquals(e.getMessage(),"Function func wrong number of arguments");
            return;
        }
    }

    @Test
    public void ParserTestCallingFunctionWithUndeclaredVariable() {
        Ast treeToExecute = null;
        try {
            treeToExecute = prepareAst("astfiles/test6.c");
            treeToExecute.preExecuting();
        } catch (Exception e) {
            assertEquals(e.getMessage(),"ERROR variable b not found");
            return;
        }
    }

    @Test
    public void ParserTestCallingFunctionTooManyArguments() {
        Ast treeToExecute = null;
        try {
            treeToExecute = prepareAst("astfiles/test7.c");
            treeToExecute.preExecuting();
        } catch (Exception e) {
            assertEquals(e.getMessage(),"Function func wrong number of arguments");
            return;
        }
    }

    @Test
    public void ParserTestMultipleFunctionDeclaration() {
        Ast treeToExecute = null;
        try {
            treeToExecute = prepareAst("astfiles/test8.c");
            treeToExecute.preExecuting();
        } catch (Exception e) {
            assertEquals(e.getMessage(),"Multiple function name:func");
            return;
        }
    }

    @Test
    public void ExprTestIntReversed() {
        Ast treeToExecute = null;
        try {
            treeToExecute = prepareAst("astfiles/test9.c");
            treeToExecute.preExecuting();
        } catch (Exception e) {
            assertFalse(true);
            return;
        }
        treeToExecute.setMode(1);
        treeToExecute.execute();
        assertEquals(treeToExecute.getRetVal(), -1);
    }

    @Test
    public void ExprTestAddition() {
        Ast treeToExecute = null;
        try {
            treeToExecute = prepareAst("astfiles/test10.c");
            treeToExecute.preExecuting();
        } catch (Exception e) {
            assertFalse(true);
            return;
        }
        treeToExecute.setMode(1);
        treeToExecute.execute();
        /*(1+2)*/
        assertEquals(treeToExecute.getRetVal(), 3);
    }

    @Test
    public void ExprTestMultipleBeforeAdding() {
        Ast treeToExecute = null;
        try {
            treeToExecute = prepareAst("astfiles/test11.c");
            treeToExecute.preExecuting();
        } catch (Exception e) {
            assertFalse(true);
            return;
        }
        treeToExecute.setMode(1);
        treeToExecute.execute();
        /*(2*2+3)*/
        assertEquals(treeToExecute.getRetVal(), 7);
    }

    @Test
    public void ExprTestOneEqualsOne() {
        Ast treeToExecute = null;
        try {
            treeToExecute = prepareAst("astfiles/test12.c");
            treeToExecute.preExecuting();
        } catch (Exception e) {
            assertFalse(true);
            return;
        }
        treeToExecute.setMode(1);
        treeToExecute.execute();
        /*true*/
        assertEquals(treeToExecute.getRetVal(), 1);
    }

    @Test
    public void ExprTestOneNotEqualsTwo() {
        Ast treeToExecute = null;
        try {
            treeToExecute = prepareAst("astfiles/test13.c");
            treeToExecute.preExecuting();
        } catch (Exception e) {
            assertFalse(true);
            return;
        }
        treeToExecute.setMode(1);
        treeToExecute.execute();

        assertEquals(treeToExecute.getRetVal(), 0);
    }

    @Test
    public void ExprTestFactorial() {
        Ast treeToExecute = null;
        try {
            treeToExecute = prepareAst("astfiles/test14.c");
            treeToExecute.preExecuting();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertFalse(true);
            return;
        }
        treeToExecute.setMode(1);
        treeToExecute.execute();

        assertEquals(treeToExecute.getRetVal(), 120);
    }

    @Test
    public void PaserTestOverrideArgunentInFunction() {
        Ast treeToExecute = null;
        try {
            treeToExecute = prepareAst("astfiles/test15.c");
            treeToExecute.preExecuting();
        } catch (Exception e) {
            assertEquals(e.getMessage(),"ERROR override a param");
            return;
        }
    }

    private Ast prepareAst(String filename) throws Exception {
        CharStream stream = null;
        try{
            stream =new ANTLRFileStream(filename);
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


        AlgoBlocksParser.ProgramContext tree = parser.program();

        ProgramListener programListener = new ProgramListener();
        ParseTreeWalker.DEFAULT.walk(programListener, tree);

        return programListener.getAst();
    }

}// parserTests
