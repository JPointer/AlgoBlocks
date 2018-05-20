package parser;// Generated from /home/piotr/IdeaProjects/AlgoBlocks/src/main/resources/AlgoBlocks.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlgoBlocksParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlgoBlocksVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(AlgoBlocksParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(AlgoBlocksParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(AlgoBlocksParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#mainFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainFunc(AlgoBlocksParser.MainFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(AlgoBlocksParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(AlgoBlocksParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#declarationStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationStmt(AlgoBlocksParser.DeclarationStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(AlgoBlocksParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#assignmentStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStmt(AlgoBlocksParser.AssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(AlgoBlocksParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#writeStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStmt(AlgoBlocksParser.WriteStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#readStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStmt(AlgoBlocksParser.ReadStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#writeParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteParams(AlgoBlocksParser.WriteParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(AlgoBlocksParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#mainAnn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainAnn(AlgoBlocksParser.MainAnnContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#funcAnn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncAnn(AlgoBlocksParser.FuncAnnContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#readAnn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadAnn(AlgoBlocksParser.ReadAnnContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#writeAnn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteAnn(AlgoBlocksParser.WriteAnnContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#declAnn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclAnn(AlgoBlocksParser.DeclAnnContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#assignAnn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignAnn(AlgoBlocksParser.AssignAnnContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#retAnn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetAnn(AlgoBlocksParser.RetAnnContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#ifAnn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfAnn(AlgoBlocksParser.IfAnnContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#whileAnn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileAnn(AlgoBlocksParser.WhileAnnContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#annBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnBody(AlgoBlocksParser.AnnBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#xVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXVal(AlgoBlocksParser.XValContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#yVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYVal(AlgoBlocksParser.YValContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#wVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWVal(AlgoBlocksParser.WValContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#hVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHVal(AlgoBlocksParser.HValContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#pVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPVal(AlgoBlocksParser.PValContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(AlgoBlocksParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(AlgoBlocksParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(AlgoBlocksParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#eqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(AlgoBlocksParser.EqExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#relExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExpr(AlgoBlocksParser.RelExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(AlgoBlocksParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#mulExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(AlgoBlocksParser.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(AlgoBlocksParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(AlgoBlocksParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgoBlocksParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(AlgoBlocksParser.FuncCallContext ctx);
}