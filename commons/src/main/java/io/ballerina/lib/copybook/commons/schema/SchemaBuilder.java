/*
 * Copyright (c) 2023, WSO2 LLC. (http://www.wso2.com) All Rights Reserved.
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.lib.copybook.commons.schema;

import io.ballerina.lib.copybook.commons.generated.CopybookVisitor;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.ballerina.lib.copybook.commons.generated.CopybookParser.BooleanLiteralContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.CicsDfhRespLiteralContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.CicsDfhValueLiteralContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.CobolWordContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.ConditionNameContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataBlankWhenZeroClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataDescriptionContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataDescriptionEntryClausesContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataDescriptionEntryContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataDescriptionEntryFormat1Context;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataDescriptionEntryFormat2Context;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataDescriptionEntryFormat3Context;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataExternalClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataGlobalClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataJustifiedClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataNameContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataOccursClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataOccursSortContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataOccursToContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataPictureClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataRedefinesClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataRenamesClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataSignClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataSynchronizedClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataUsageClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataValueClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataValueIntervalContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataValueIntervalFromContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataValueIntervalToContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.FigurativeConstantContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.IdentifierContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.IndexNameContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.IntegerLiteralContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.LiteralContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.NumericLiteralContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.PictureCardinalityContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.PictureCharsContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.PictureStringContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.QualifiedDataNameContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.StartRuleContext;

class SchemaBuilder implements CopybookVisitor<CopybookNode> {
    private final Schema schema = new Schema();
    private GroupItem possibleParent;
    private final Set<String> redefinedItemNames = new HashSet<>();
    private final List<String> errors = new ArrayList<>();
    private DataItem possibleEnum;
    private int rootLevel = -1;
    private static final String SPACE = " ";
    private static final String ZERO = "0";
    Schema getSchema() {
        return this.schema;
    }

    @Override
    public CopybookNode visitStartRule(StartRuleContext ctx) {
        this.possibleParent = null;
        visitDataDescription(ctx.dataDescription());
        for (CopybookNode typedef : this.schema.getTypeDefinitions()) {
            addRedefinedItems(typedef);
        }
        this.schema.addErrors(this.errors);
        return null;
    }

    private void addRedefinedItems(CopybookNode item) {
        if (this.redefinedItemNames.contains(item.getName())) {
            this.schema.addRedefinedItem(item);
            return;
        }
        if (item instanceof GroupItem groupItem) {
            groupItem.getChildren().forEach(this::addRedefinedItems);
        }
    }

    @Override
    public CopybookNode visitDataDescription(DataDescriptionContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            CopybookNode copybookNode = visitDataDescriptionEntry(ctx.dataDescriptionEntry(i));
            setRootLevel(copybookNode);
            if (copybookNode instanceof GroupItem groupItem) {
                this.possibleParent = groupItem;
            }
            if (isRootLevelNode(copybookNode)) {
                this.schema.addTypeDefinition(copybookNode);
            }
        }
        return null;
    }

    private void setRootLevel(CopybookNode copybookNode) {
        if (copybookNode != null && (this.rootLevel == -1 || this.rootLevel > copybookNode.getLevel())) {
            this.rootLevel = copybookNode.getLevel();
        }
    }

    private boolean isRootLevelNode(CopybookNode copybookNode) {
        return copybookNode != null && copybookNode.getLevel() == this.rootLevel;
    }

    @Override
    public CopybookNode visitDataDescriptionEntry(DataDescriptionEntryContext ctx) {
        if (ctx.dataDescriptionEntryFormat1() != null) {
            return visitDataDescriptionEntryFormat1(ctx.dataDescriptionEntryFormat1());
        }
        if (ctx.dataDescriptionEntryFormat3() != null) {
            return visitDataDescriptionEntryFormat3(ctx.dataDescriptionEntryFormat3());
        }
        // skipping level 66
        return null;
    }

    @Override
    public CopybookNode visitDataDescriptionEntryFormat1(DataDescriptionEntryFormat1Context ctx) {
        if (ctx.LEVEL_NUMBER_77() != null) {
            // skipping level 77
            return null;
        }

        boolean redefines = ctx.dataDescriptionEntryClauses().dataRedefinesClause(0) != null;
        String redefinedItemName = null;
        if (redefines) {
            redefinedItemName = ctx.dataDescriptionEntryClauses().dataRedefinesClause(0).dataName().getText();
            this.redefinedItemNames.add(redefinedItemName);
        }

        int level = Integer.parseInt(ctx.INTEGERLITERAL().getText());
        String name = ctx.dataName() != null ? ctx.dataName().getText() : ctx.FILLER().getText();
        DataPictureClauseContext pictureClause = ctx.dataDescriptionEntryClauses().dataPictureClause(0);
        DataOccursClauseContext occursClause = ctx.dataDescriptionEntryClauses().dataOccursClause(0);
        int occurs = Utils.getOccurringCount(occursClause);
        if (pictureClause == null || pictureClause.pictureString() == null) {
            return new GroupItem(level, name, occurs, redefinedItemName, getParent(level));
        }
        PictureStringContext pictureType = pictureClause.pictureString();
                validatePicture(pictureType);
        int readLength = Utils.getReadLength(pictureType);
        var valueClause = ctx.dataDescriptionEntryClauses().dataValueClause(0);
        String defaultValue = this.getDataValue(valueClause, readLength);
        DataItem dataItem = new DataItem(level, name, Utils.getPictureString(pictureType), Utils.isNumeric(pictureType),
                readLength, occurs, Utils.getFloatingPointLength(pictureType), redefinedItemName, defaultValue,
                getParent(level));
        this.possibleEnum = dataItem;
        return dataItem;
    }

    private void validatePicture(PictureStringContext pictureType) {
        String pictureString = Utils.getPictureString(pictureType);
        if (PictureStringValidator.isSupportedPictureString(pictureString)) {
            return;
        }
        String errorMsg = "Unsupported picture string '" + pictureString + "' found in copybook schema";
        this.addError(pictureType.start.getLine(), pictureType.start.getCharPositionInLine(), errorMsg);
    }

    private String getDataValue(DataValueClauseContext ctx, int readLength) {
        if (ctx == null) {
            return null;
        }
        try {
            DataValueIntervalContext dataValueInterval = ctx.dataValueInterval(0);
            LiteralContext literal = dataValueInterval.dataValueIntervalFrom().literal();
            FigurativeConstantContext figurativeConstantContext = literal.figurativeConstant();
            if (figurativeConstantContext != null) {
                return getDataValue(figurativeConstantContext, readLength);
            }
            TerminalNode nonNumericLiteral = literal.NONNUMERICLITERAL();
            if (nonNumericLiteral != null) {
                return getDataValue(literal, nonNumericLiteral);
            }
            NumericLiteralContext numericLiteral = literal.numericLiteral();
            if (numericLiteral != null) {
                return getDataValue(numericLiteral);
            }
        } catch (NullPointerException exception) {
            addStatementNotSupportedError(ctx);
            return null;
        }
        addStatementNotSupportedError(ctx);
        return null;
    }

    private String getDataValue(FigurativeConstantContext ctx, int readLength) {
        if (ctx == null) {
            return null;
        }
        if (ctx.SPACE() != null) {
            return SPACE;
        }
        if (ctx.ZERO() != null) {
            return ZERO;
        }
        if (ctx.SPACES() != null) {
            return SPACE.repeat(readLength);
        }
        if (ctx.ZEROES() != null || ctx.ZEROS() != null) {
            return ZERO.repeat(readLength);
        }
        if (ctx.LOW_VALUE() != null) {
            return ZERO;
        }
        if (ctx.LOW_VALUES() != null) {
            return ZERO.repeat(readLength);
        }
        addStatementNotSupportedError(ctx);
        return null;
    }

    private String getDataValue(LiteralContext literalContext, TerminalNode nonNumericLiteral) {
        String defaultValue = nonNumericLiteral.getText();
        if (Pattern.matches("^[xX].*$", defaultValue)) {
            addError(literalContext.start.getLine(), literalContext.start.getCharPositionInLine(),
                    "Hexadecimal value '" + defaultValue + "' is not supported as a default value.");
            return null;
        }
        if (Pattern.matches("^[zZ].*$", defaultValue)) {
            addError(literalContext.start.getLine(), literalContext.start.getCharPositionInLine(),
                    "Null terminated value '" + defaultValue + "' is not supported as a default value.");
            return null;
        }
        Matcher matcher = Pattern.compile("^['\"](?<stringValue>.*)['\"]$").matcher(defaultValue);
        return matcher.find() ? matcher.group("stringValue") : defaultValue;
    }

    private String getDataValue(NumericLiteralContext numericLiteral) {
        if (numericLiteral.NUMERICLITERAL() != null) {
            String numericLiteralText = numericLiteral.NUMERICLITERAL().getText();
            if (numericLiteralText.contains("e") || numericLiteralText.contains("E")) {
                addError(numericLiteral.start.getLine(), numericLiteral.start.getCharPositionInLine(),
                        "Scientific notation '" + numericLiteralText + "' is not supported as a default value.");
            }
        }
        if (numericLiteral.ZERO() != null) {
            return ZERO;
        }
        return numericLiteral.getText();
    }

    private void addStatementNotSupportedError(ParserRuleContext ctx) {
        Interval statementInterval = new Interval(ctx.start.getStartIndex(), ctx.stop.getStopIndex());
        String statement = ctx.start.getInputStream().getText(statementInterval);
        addError(ctx.start.getLine(), ctx.start.getCharPositionInLine(),
                "Copybook statement '" + statement + "' is not supported.");
    }

    @Override
    public CopybookNode visitDataDescriptionEntryClauses(DataDescriptionEntryClausesContext ctx) {
        return null;
    }

    private GroupItem getParent(int currentLevel) {
        GroupItem parent = this.possibleParent;
        while (parent != null && parent.getLevel() >= currentLevel) {
            parent = parent.getParent();
        }
        return parent;
    }

    @Override
    public CopybookNode visitDataDescriptionEntryFormat2(DataDescriptionEntryFormat2Context ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataDescriptionEntryFormat3(DataDescriptionEntryFormat3Context ctx) {
        DataValueClauseContext valueClause = ctx.dataValueClause();
        if (valueClause.VALUE() != null) {
            var dataValueIntervalContext = valueClause.dataValueInterval(0);
            var literal = dataValueIntervalContext.dataValueIntervalFrom().literal();
            if (literal != null) {
                // Remove quotes from value if available (.ie 'N' -> N, "N" -> N)
                Matcher matcher = Pattern.compile("^['\"](?<stringValue>.*)['\"]$").matcher(literal.getText());
                String value =  matcher.find() ? matcher.group("stringValue") : literal.getText();
                if (value.length() > this.possibleEnum.getReadLength()) {
                    String errorMsg = "Invalid enum value '" + value + "' found in copybook schema. "
                            + "The value's length exceeds the defined length for enum '"
                            + this.possibleEnum.getName() + ".";
                    this.addError(literal.start.getLine(), literal.start.getCharPositionInLine(), errorMsg);
                    return null;
                }
                this.possibleEnum.addEnumValues(value);
            }
        }
        return null;
    }

    private void addError(int line, int charPositionInLine, String msg) {
        this.errors.add("Error at line " + line + ", column " + charPositionInLine + ": " + msg);
    }

    @Override
    public CopybookNode visitDataBlankWhenZeroClause(DataBlankWhenZeroClauseContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataExternalClause(DataExternalClauseContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataGlobalClause(DataGlobalClauseContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataJustifiedClause(DataJustifiedClauseContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataOccursClause(DataOccursClauseContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataOccursTo(DataOccursToContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataOccursSort(DataOccursSortContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataPictureClause(DataPictureClauseContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitPictureString(PictureStringContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitPictureChars(PictureCharsContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitPictureCardinality(PictureCardinalityContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataRedefinesClause(DataRedefinesClauseContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataRenamesClause(DataRenamesClauseContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataSignClause(DataSignClauseContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataSynchronizedClause(DataSynchronizedClauseContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataUsageClause(DataUsageClauseContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataValueClause(DataValueClauseContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataValueInterval(DataValueIntervalContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataValueIntervalFrom(DataValueIntervalFromContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataValueIntervalTo(DataValueIntervalToContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitIdentifier(IdentifierContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitQualifiedDataName(QualifiedDataNameContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitConditionName(ConditionNameContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitDataName(DataNameContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitIndexName(IndexNameContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitCobolWord(CobolWordContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitLiteral(LiteralContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitBooleanLiteral(BooleanLiteralContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitNumericLiteral(NumericLiteralContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitIntegerLiteral(IntegerLiteralContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitCicsDfhRespLiteral(CicsDfhRespLiteralContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitCicsDfhValueLiteral(CicsDfhValueLiteralContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visitFigurativeConstant(FigurativeConstantContext ctx) {
        return null;
    }

    @Override
    public CopybookNode visit(ParseTree tree) {
        return null;
    }

    @Override
    public CopybookNode visitChildren(RuleNode node) {
        return null;
    }

    @Override
    public CopybookNode visitTerminal(TerminalNode node) {
        return null;
    }

    @Override
    public CopybookNode visitErrorNode(ErrorNode node) {
        return null;
    }
}
