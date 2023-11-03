// Generated from Copybook.g4 by ANTLR 4.13.1
package io.ballerina.lib.copybook.commons.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CopybookParser}.
 */
public interface CopybookListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CopybookParser#startRule}.
	 * @param ctx the parse tree
	 */
	void enterStartRule(CopybookParser.StartRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#startRule}.
	 * @param ctx the parse tree
	 */
	void exitStartRule(CopybookParser.StartRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataDescription}.
	 * @param ctx the parse tree
	 */
	void enterDataDescription(CopybookParser.DataDescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataDescription}.
	 * @param ctx the parse tree
	 */
	void exitDataDescription(CopybookParser.DataDescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataDescriptionEntry}.
	 * @param ctx the parse tree
	 */
	void enterDataDescriptionEntry(CopybookParser.DataDescriptionEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataDescriptionEntry}.
	 * @param ctx the parse tree
	 */
	void exitDataDescriptionEntry(CopybookParser.DataDescriptionEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataDescriptionEntryFormat1}.
	 * @param ctx the parse tree
	 */
	void enterDataDescriptionEntryFormat1(CopybookParser.DataDescriptionEntryFormat1Context ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataDescriptionEntryFormat1}.
	 * @param ctx the parse tree
	 */
	void exitDataDescriptionEntryFormat1(CopybookParser.DataDescriptionEntryFormat1Context ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataDescriptionEntryClauses}.
	 * @param ctx the parse tree
	 */
	void enterDataDescriptionEntryClauses(CopybookParser.DataDescriptionEntryClausesContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataDescriptionEntryClauses}.
	 * @param ctx the parse tree
	 */
	void exitDataDescriptionEntryClauses(CopybookParser.DataDescriptionEntryClausesContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataDescriptionEntryFormat2}.
	 * @param ctx the parse tree
	 */
	void enterDataDescriptionEntryFormat2(CopybookParser.DataDescriptionEntryFormat2Context ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataDescriptionEntryFormat2}.
	 * @param ctx the parse tree
	 */
	void exitDataDescriptionEntryFormat2(CopybookParser.DataDescriptionEntryFormat2Context ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataDescriptionEntryFormat3}.
	 * @param ctx the parse tree
	 */
	void enterDataDescriptionEntryFormat3(CopybookParser.DataDescriptionEntryFormat3Context ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataDescriptionEntryFormat3}.
	 * @param ctx the parse tree
	 */
	void exitDataDescriptionEntryFormat3(CopybookParser.DataDescriptionEntryFormat3Context ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataBlankWhenZeroClause}.
	 * @param ctx the parse tree
	 */
	void enterDataBlankWhenZeroClause(CopybookParser.DataBlankWhenZeroClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataBlankWhenZeroClause}.
	 * @param ctx the parse tree
	 */
	void exitDataBlankWhenZeroClause(CopybookParser.DataBlankWhenZeroClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataExternalClause}.
	 * @param ctx the parse tree
	 */
	void enterDataExternalClause(CopybookParser.DataExternalClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataExternalClause}.
	 * @param ctx the parse tree
	 */
	void exitDataExternalClause(CopybookParser.DataExternalClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataGlobalClause}.
	 * @param ctx the parse tree
	 */
	void enterDataGlobalClause(CopybookParser.DataGlobalClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataGlobalClause}.
	 * @param ctx the parse tree
	 */
	void exitDataGlobalClause(CopybookParser.DataGlobalClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataJustifiedClause}.
	 * @param ctx the parse tree
	 */
	void enterDataJustifiedClause(CopybookParser.DataJustifiedClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataJustifiedClause}.
	 * @param ctx the parse tree
	 */
	void exitDataJustifiedClause(CopybookParser.DataJustifiedClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataOccursClause}.
	 * @param ctx the parse tree
	 */
	void enterDataOccursClause(CopybookParser.DataOccursClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataOccursClause}.
	 * @param ctx the parse tree
	 */
	void exitDataOccursClause(CopybookParser.DataOccursClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataOccursTo}.
	 * @param ctx the parse tree
	 */
	void enterDataOccursTo(CopybookParser.DataOccursToContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataOccursTo}.
	 * @param ctx the parse tree
	 */
	void exitDataOccursTo(CopybookParser.DataOccursToContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataOccursSort}.
	 * @param ctx the parse tree
	 */
	void enterDataOccursSort(CopybookParser.DataOccursSortContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataOccursSort}.
	 * @param ctx the parse tree
	 */
	void exitDataOccursSort(CopybookParser.DataOccursSortContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataPictureClause}.
	 * @param ctx the parse tree
	 */
	void enterDataPictureClause(CopybookParser.DataPictureClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataPictureClause}.
	 * @param ctx the parse tree
	 */
	void exitDataPictureClause(CopybookParser.DataPictureClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#pictureString}.
	 * @param ctx the parse tree
	 */
	void enterPictureString(CopybookParser.PictureStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#pictureString}.
	 * @param ctx the parse tree
	 */
	void exitPictureString(CopybookParser.PictureStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#pictureChars}.
	 * @param ctx the parse tree
	 */
	void enterPictureChars(CopybookParser.PictureCharsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#pictureChars}.
	 * @param ctx the parse tree
	 */
	void exitPictureChars(CopybookParser.PictureCharsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#pictureCardinality}.
	 * @param ctx the parse tree
	 */
	void enterPictureCardinality(CopybookParser.PictureCardinalityContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#pictureCardinality}.
	 * @param ctx the parse tree
	 */
	void exitPictureCardinality(CopybookParser.PictureCardinalityContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataRedefinesClause}.
	 * @param ctx the parse tree
	 */
	void enterDataRedefinesClause(CopybookParser.DataRedefinesClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataRedefinesClause}.
	 * @param ctx the parse tree
	 */
	void exitDataRedefinesClause(CopybookParser.DataRedefinesClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataRenamesClause}.
	 * @param ctx the parse tree
	 */
	void enterDataRenamesClause(CopybookParser.DataRenamesClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataRenamesClause}.
	 * @param ctx the parse tree
	 */
	void exitDataRenamesClause(CopybookParser.DataRenamesClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataSignClause}.
	 * @param ctx the parse tree
	 */
	void enterDataSignClause(CopybookParser.DataSignClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataSignClause}.
	 * @param ctx the parse tree
	 */
	void exitDataSignClause(CopybookParser.DataSignClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataSynchronizedClause}.
	 * @param ctx the parse tree
	 */
	void enterDataSynchronizedClause(CopybookParser.DataSynchronizedClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataSynchronizedClause}.
	 * @param ctx the parse tree
	 */
	void exitDataSynchronizedClause(CopybookParser.DataSynchronizedClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataUsageClause}.
	 * @param ctx the parse tree
	 */
	void enterDataUsageClause(CopybookParser.DataUsageClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataUsageClause}.
	 * @param ctx the parse tree
	 */
	void exitDataUsageClause(CopybookParser.DataUsageClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataValueClause}.
	 * @param ctx the parse tree
	 */
	void enterDataValueClause(CopybookParser.DataValueClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataValueClause}.
	 * @param ctx the parse tree
	 */
	void exitDataValueClause(CopybookParser.DataValueClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataValueInterval}.
	 * @param ctx the parse tree
	 */
	void enterDataValueInterval(CopybookParser.DataValueIntervalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataValueInterval}.
	 * @param ctx the parse tree
	 */
	void exitDataValueInterval(CopybookParser.DataValueIntervalContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataValueIntervalFrom}.
	 * @param ctx the parse tree
	 */
	void enterDataValueIntervalFrom(CopybookParser.DataValueIntervalFromContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataValueIntervalFrom}.
	 * @param ctx the parse tree
	 */
	void exitDataValueIntervalFrom(CopybookParser.DataValueIntervalFromContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataValueIntervalTo}.
	 * @param ctx the parse tree
	 */
	void enterDataValueIntervalTo(CopybookParser.DataValueIntervalToContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataValueIntervalTo}.
	 * @param ctx the parse tree
	 */
	void exitDataValueIntervalTo(CopybookParser.DataValueIntervalToContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(CopybookParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(CopybookParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#qualifiedDataName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedDataName(CopybookParser.QualifiedDataNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#qualifiedDataName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedDataName(CopybookParser.QualifiedDataNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#conditionName}.
	 * @param ctx the parse tree
	 */
	void enterConditionName(CopybookParser.ConditionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#conditionName}.
	 * @param ctx the parse tree
	 */
	void exitConditionName(CopybookParser.ConditionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#dataName}.
	 * @param ctx the parse tree
	 */
	void enterDataName(CopybookParser.DataNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#dataName}.
	 * @param ctx the parse tree
	 */
	void exitDataName(CopybookParser.DataNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#indexName}.
	 * @param ctx the parse tree
	 */
	void enterIndexName(CopybookParser.IndexNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#indexName}.
	 * @param ctx the parse tree
	 */
	void exitIndexName(CopybookParser.IndexNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#cobolWord}.
	 * @param ctx the parse tree
	 */
	void enterCobolWord(CopybookParser.CobolWordContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#cobolWord}.
	 * @param ctx the parse tree
	 */
	void exitCobolWord(CopybookParser.CobolWordContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(CopybookParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(CopybookParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(CopybookParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(CopybookParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#numericLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumericLiteral(CopybookParser.NumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#numericLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumericLiteral(CopybookParser.NumericLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(CopybookParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(CopybookParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#cicsDfhRespLiteral}.
	 * @param ctx the parse tree
	 */
	void enterCicsDfhRespLiteral(CopybookParser.CicsDfhRespLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#cicsDfhRespLiteral}.
	 * @param ctx the parse tree
	 */
	void exitCicsDfhRespLiteral(CopybookParser.CicsDfhRespLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#cicsDfhValueLiteral}.
	 * @param ctx the parse tree
	 */
	void enterCicsDfhValueLiteral(CopybookParser.CicsDfhValueLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#cicsDfhValueLiteral}.
	 * @param ctx the parse tree
	 */
	void exitCicsDfhValueLiteral(CopybookParser.CicsDfhValueLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CopybookParser#figurativeConstant}.
	 * @param ctx the parse tree
	 */
	void enterFigurativeConstant(CopybookParser.FigurativeConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link CopybookParser#figurativeConstant}.
	 * @param ctx the parse tree
	 */
	void exitFigurativeConstant(CopybookParser.FigurativeConstantContext ctx);
}