// Generated from Copybook.g4 by ANTLR 4.13.1
package io.ballerina.lib.copybook.commons.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CopybookParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CopybookVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CopybookParser#startRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartRule(CopybookParser.StartRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataDescription}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataDescription(CopybookParser.DataDescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataDescriptionEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataDescriptionEntry(CopybookParser.DataDescriptionEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataDescriptionEntryFormat1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataDescriptionEntryFormat1(CopybookParser.DataDescriptionEntryFormat1Context ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataDescriptionEntryClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataDescriptionEntryClauses(CopybookParser.DataDescriptionEntryClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataDescriptionEntryFormat2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataDescriptionEntryFormat2(CopybookParser.DataDescriptionEntryFormat2Context ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataDescriptionEntryFormat3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataDescriptionEntryFormat3(CopybookParser.DataDescriptionEntryFormat3Context ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataBlankWhenZeroClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataBlankWhenZeroClause(CopybookParser.DataBlankWhenZeroClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataExternalClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataExternalClause(CopybookParser.DataExternalClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataGlobalClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataGlobalClause(CopybookParser.DataGlobalClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataJustifiedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataJustifiedClause(CopybookParser.DataJustifiedClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataOccursClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataOccursClause(CopybookParser.DataOccursClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataOccursTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataOccursTo(CopybookParser.DataOccursToContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataOccursSort}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataOccursSort(CopybookParser.DataOccursSortContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataPictureClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataPictureClause(CopybookParser.DataPictureClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#pictureString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPictureString(CopybookParser.PictureStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#pictureChars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPictureChars(CopybookParser.PictureCharsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#pictureCardinality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPictureCardinality(CopybookParser.PictureCardinalityContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataRedefinesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataRedefinesClause(CopybookParser.DataRedefinesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataRenamesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataRenamesClause(CopybookParser.DataRenamesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataSignClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataSignClause(CopybookParser.DataSignClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataSynchronizedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataSynchronizedClause(CopybookParser.DataSynchronizedClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataUsageClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataUsageClause(CopybookParser.DataUsageClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataValueClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataValueClause(CopybookParser.DataValueClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataValueInterval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataValueInterval(CopybookParser.DataValueIntervalContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataValueIntervalFrom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataValueIntervalFrom(CopybookParser.DataValueIntervalFromContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataValueIntervalTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataValueIntervalTo(CopybookParser.DataValueIntervalToContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(CopybookParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#qualifiedDataName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedDataName(CopybookParser.QualifiedDataNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#conditionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionName(CopybookParser.ConditionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#dataName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataName(CopybookParser.DataNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#indexName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexName(CopybookParser.IndexNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#cobolWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCobolWord(CopybookParser.CobolWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(CopybookParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(CopybookParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#numericLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLiteral(CopybookParser.NumericLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#integerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(CopybookParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#cicsDfhRespLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCicsDfhRespLiteral(CopybookParser.CicsDfhRespLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#cicsDfhValueLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCicsDfhValueLiteral(CopybookParser.CicsDfhValueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopybookParser#figurativeConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFigurativeConstant(CopybookParser.FigurativeConstantContext ctx);
}