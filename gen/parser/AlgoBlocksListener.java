package parser;// Generated from /home/piotr/IdeaProjects/AlgoBlocks/src/main/resources/AlgoBlocks.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AlgoBlocksParser}.
 */
public interface AlgoBlocksListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(AlgoBlocksParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(AlgoBlocksParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(AlgoBlocksParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(AlgoBlocksParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(AlgoBlocksParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(AlgoBlocksParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#mainFunc}.
	 * @param ctx the parse tree
	 */
	void enterMainFunc(AlgoBlocksParser.MainFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#mainFunc}.
	 * @param ctx the parse tree
	 */
	void exitMainFunc(AlgoBlocksParser.MainFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(AlgoBlocksParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(AlgoBlocksParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(AlgoBlocksParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(AlgoBlocksParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#declarationStmt}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationStmt(AlgoBlocksParser.DeclarationStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#declarationStmt}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationStmt(AlgoBlocksParser.DeclarationStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(AlgoBlocksParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(AlgoBlocksParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#assignmentStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStmt(AlgoBlocksParser.AssignmentStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#assignmentStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStmt(AlgoBlocksParser.AssignmentStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(AlgoBlocksParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(AlgoBlocksParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void enterWriteStmt(AlgoBlocksParser.WriteStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void exitWriteStmt(AlgoBlocksParser.WriteStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#readStmt}.
	 * @param ctx the parse tree
	 */
	void enterReadStmt(AlgoBlocksParser.ReadStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#readStmt}.
	 * @param ctx the parse tree
	 */
	void exitReadStmt(AlgoBlocksParser.ReadStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#writeParams}.
	 * @param ctx the parse tree
	 */
	void enterWriteParams(AlgoBlocksParser.WriteParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#writeParams}.
	 * @param ctx the parse tree
	 */
	void exitWriteParams(AlgoBlocksParser.WriteParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(AlgoBlocksParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(AlgoBlocksParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#mainAnn}.
	 * @param ctx the parse tree
	 */
	void enterMainAnn(AlgoBlocksParser.MainAnnContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#mainAnn}.
	 * @param ctx the parse tree
	 */
	void exitMainAnn(AlgoBlocksParser.MainAnnContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#funcAnn}.
	 * @param ctx the parse tree
	 */
	void enterFuncAnn(AlgoBlocksParser.FuncAnnContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#funcAnn}.
	 * @param ctx the parse tree
	 */
	void exitFuncAnn(AlgoBlocksParser.FuncAnnContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#readAnn}.
	 * @param ctx the parse tree
	 */
	void enterReadAnn(AlgoBlocksParser.ReadAnnContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#readAnn}.
	 * @param ctx the parse tree
	 */
	void exitReadAnn(AlgoBlocksParser.ReadAnnContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#writeAnn}.
	 * @param ctx the parse tree
	 */
	void enterWriteAnn(AlgoBlocksParser.WriteAnnContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#writeAnn}.
	 * @param ctx the parse tree
	 */
	void exitWriteAnn(AlgoBlocksParser.WriteAnnContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#declAnn}.
	 * @param ctx the parse tree
	 */
	void enterDeclAnn(AlgoBlocksParser.DeclAnnContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#declAnn}.
	 * @param ctx the parse tree
	 */
	void exitDeclAnn(AlgoBlocksParser.DeclAnnContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#assignAnn}.
	 * @param ctx the parse tree
	 */
	void enterAssignAnn(AlgoBlocksParser.AssignAnnContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#assignAnn}.
	 * @param ctx the parse tree
	 */
	void exitAssignAnn(AlgoBlocksParser.AssignAnnContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#retAnn}.
	 * @param ctx the parse tree
	 */
	void enterRetAnn(AlgoBlocksParser.RetAnnContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#retAnn}.
	 * @param ctx the parse tree
	 */
	void exitRetAnn(AlgoBlocksParser.RetAnnContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#ifAnn}.
	 * @param ctx the parse tree
	 */
	void enterIfAnn(AlgoBlocksParser.IfAnnContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#ifAnn}.
	 * @param ctx the parse tree
	 */
	void exitIfAnn(AlgoBlocksParser.IfAnnContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#whileAnn}.
	 * @param ctx the parse tree
	 */
	void enterWhileAnn(AlgoBlocksParser.WhileAnnContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#whileAnn}.
	 * @param ctx the parse tree
	 */
	void exitWhileAnn(AlgoBlocksParser.WhileAnnContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#annBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnBody(AlgoBlocksParser.AnnBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#annBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnBody(AlgoBlocksParser.AnnBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#xVal}.
	 * @param ctx the parse tree
	 */
	void enterXVal(AlgoBlocksParser.XValContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#xVal}.
	 * @param ctx the parse tree
	 */
	void exitXVal(AlgoBlocksParser.XValContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#yVal}.
	 * @param ctx the parse tree
	 */
	void enterYVal(AlgoBlocksParser.YValContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#yVal}.
	 * @param ctx the parse tree
	 */
	void exitYVal(AlgoBlocksParser.YValContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#wVal}.
	 * @param ctx the parse tree
	 */
	void enterWVal(AlgoBlocksParser.WValContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#wVal}.
	 * @param ctx the parse tree
	 */
	void exitWVal(AlgoBlocksParser.WValContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#hVal}.
	 * @param ctx the parse tree
	 */
	void enterHVal(AlgoBlocksParser.HValContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#hVal}.
	 * @param ctx the parse tree
	 */
	void exitHVal(AlgoBlocksParser.HValContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#pVal}.
	 * @param ctx the parse tree
	 */
	void enterPVal(AlgoBlocksParser.PValContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#pVal}.
	 * @param ctx the parse tree
	 */
	void exitPVal(AlgoBlocksParser.PValContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(AlgoBlocksParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(AlgoBlocksParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(AlgoBlocksParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(AlgoBlocksParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(AlgoBlocksParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(AlgoBlocksParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(AlgoBlocksParser.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(AlgoBlocksParser.EqExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr(AlgoBlocksParser.RelExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr(AlgoBlocksParser.RelExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(AlgoBlocksParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(AlgoBlocksParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(AlgoBlocksParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(AlgoBlocksParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(AlgoBlocksParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(AlgoBlocksParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(AlgoBlocksParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(AlgoBlocksParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgoBlocksParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(AlgoBlocksParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgoBlocksParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(AlgoBlocksParser.FuncCallContext ctx);
}