// Generated from CopyBook.g4 by ANTLR 4.13.1
package io.ballerina.lib.copybook.commons.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CopyBookParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CopyBookVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#startRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartRule(CopyBookParser.StartRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataDescription}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataDescription(CopyBookParser.DataDescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataDescriptionEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataDescriptionEntry(CopyBookParser.DataDescriptionEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataDescriptionEntryFormat1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataDescriptionEntryFormat1(CopyBookParser.DataDescriptionEntryFormat1Context ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataDescriptionEntryClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataDescriptionEntryClauses(CopyBookParser.DataDescriptionEntryClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataDescriptionEntryFormat2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataDescriptionEntryFormat2(CopyBookParser.DataDescriptionEntryFormat2Context ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataDescriptionEntryFormat3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataDescriptionEntryFormat3(CopyBookParser.DataDescriptionEntryFormat3Context ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataBlankWhenZeroClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataBlankWhenZeroClause(CopyBookParser.DataBlankWhenZeroClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataExternalClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataExternalClause(CopyBookParser.DataExternalClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataGlobalClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataGlobalClause(CopyBookParser.DataGlobalClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataJustifiedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataJustifiedClause(CopyBookParser.DataJustifiedClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataOccursClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataOccursClause(CopyBookParser.DataOccursClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataOccursTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataOccursTo(CopyBookParser.DataOccursToContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataOccursSort}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataOccursSort(CopyBookParser.DataOccursSortContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataPictureClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataPictureClause(CopyBookParser.DataPictureClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#pictureString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPictureString(CopyBookParser.PictureStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#pictureChars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPictureChars(CopyBookParser.PictureCharsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#pictureCardinality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPictureCardinality(CopyBookParser.PictureCardinalityContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataRedefinesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataRedefinesClause(CopyBookParser.DataRedefinesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataRenamesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataRenamesClause(CopyBookParser.DataRenamesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataSignClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataSignClause(CopyBookParser.DataSignClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataSynchronizedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataSynchronizedClause(CopyBookParser.DataSynchronizedClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataUsageClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataUsageClause(CopyBookParser.DataUsageClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataValueClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataValueClause(CopyBookParser.DataValueClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataValueInterval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataValueInterval(CopyBookParser.DataValueIntervalContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataValueIntervalFrom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataValueIntervalFrom(CopyBookParser.DataValueIntervalFromContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataValueIntervalTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataValueIntervalTo(CopyBookParser.DataValueIntervalToContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(CopyBookParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#qualifiedDataName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedDataName(CopyBookParser.QualifiedDataNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#conditionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionName(CopyBookParser.ConditionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#dataName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataName(CopyBookParser.DataNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#indexName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexName(CopyBookParser.IndexNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#cobolWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCobolWord(CopyBookParser.CobolWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(CopyBookParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(CopyBookParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#numericLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLiteral(CopyBookParser.NumericLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#integerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(CopyBookParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#cicsDfhRespLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCicsDfhRespLiteral(CopyBookParser.CicsDfhRespLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#cicsDfhValueLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCicsDfhValueLiteral(CopyBookParser.CicsDfhValueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CopyBookParser#figurativeConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFigurativeConstant(CopyBookParser.FigurativeConstantContext ctx);
}
