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
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        if (item instanceof GroupItem) {
            ((GroupItem) item).getChildren().forEach(this::addRedefinedItems);
        }
    }

    @Override
    public CopybookNode visitDataDescription(DataDescriptionContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            CopybookNode copybookNode = visitDataDescriptionEntry(ctx.dataDescriptionEntry(i));
            if (copybookNode instanceof GroupItem) {
                this.possibleParent = (GroupItem) copybookNode;
            }
            if (isRootLevelNode(copybookNode)) {
                this.schema.addTypeDefinition(copybookNode);
            }
        }
        return null;
    }

    private boolean isRootLevelNode(CopybookNode copybookNode) {
        return copybookNode != null && copybookNode.getLevel() == 1;
    }

    @Override
    public CopybookNode visitDataDescriptionEntry(DataDescriptionEntryContext ctx) {
        if (ctx.dataDescriptionEntryFormat1() != null) {
            return visitDataDescriptionEntryFormat1(ctx.dataDescriptionEntryFormat1());
        }
        // skipping level 66 and 88
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
        String pictureString = Utils.getPictureString(pictureType);
        validatePictureString(pictureString);
        return new DataItem(level, name, pictureString, Utils.isNumeric(pictureType), Utils.getReadLength(pictureType),
                            occurs, Utils.getFloatingPointLength(pictureType), redefinedItemName, getParent(level));
    }

    private void validatePictureString(String pictureString) {
        String supportedPictureFormats = "^(X+|X\\(\\d+\\)|([+-])?9+(\\.9+)?|S9\\(\\d+\\)|9\\(\\d+\\)(\\.9+)?"
                + "|(\\+|-9)\\(\\d+\\)\\.9+|Z\\(\\d+\\)9+\\.9+)$";
        if (Pattern.compile(supportedPictureFormats).matcher(pictureString).find()) {
            return;
        }
        this.errors.add("Unsupported picture string '" + pictureString + "' found in copybook schema");
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
        return null;
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
