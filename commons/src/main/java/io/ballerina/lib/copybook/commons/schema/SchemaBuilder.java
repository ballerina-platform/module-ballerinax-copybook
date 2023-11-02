package io.ballerina.lib.copybook.commons.schema;

import io.ballerina.lib.copybook.commons.generated.CopyBookVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.BooleanLiteralContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.CicsDfhRespLiteralContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.CicsDfhValueLiteralContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.CobolWordContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.ConditionNameContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataBlankWhenZeroClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataDescriptionContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataDescriptionEntryClausesContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataDescriptionEntryContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataDescriptionEntryFormat1Context;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataDescriptionEntryFormat2Context;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataDescriptionEntryFormat3Context;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataExternalClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataGlobalClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataJustifiedClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataNameContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataOccursClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataOccursSortContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataOccursToContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataPictureClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataRedefinesClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataRenamesClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataSignClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataSynchronizedClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataUsageClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataValueClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataValueIntervalContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataValueIntervalFromContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.DataValueIntervalToContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.FigurativeConstantContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.IdentifierContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.IndexNameContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.IntegerLiteralContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.LiteralContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.NumericLiteralContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.PictureCardinalityContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.PictureCharsContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.PictureStringContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.QualifiedDataNameContext;
import static io.ballerina.lib.copybook.commons.generated.CopyBookParser.StartRuleContext;

public class SchemaBuilder implements CopyBookVisitor<CopybookNode> {
    private final Schema schema = new Schema();
    private GroupItem possibleParent;
    private final Set<String> redefinedItemNames = new HashSet<>();
    private final List<String> errors = new ArrayList<>(); // TODO: check for redfinedItems in tree and put errors if
    // not exisits

    public Schema getSchema() {
        return this.schema;
    }

    @Override
    public CopybookNode visitStartRule(StartRuleContext ctx) {
        this.possibleParent = null;
        visitDataDescription(ctx.dataDescription());
        for (CopybookNode typedef : schema.getTypeDefinitions()) {
            addRedefinedItems(typedef);
        }
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

        // TODO: fix redefine clause tryout
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
            return new GroupItem(level, name, occurs, redefines, redefinedItemName, getParent(level));
        }
        PictureStringContext pictureType = pictureClause.pictureString();
        // TODO: validate picture type and add errors in the schema for currently not supported items
        return new DataItem(level, name, pictureType.getText().toUpperCase(), Utils.isNumeric(pictureType),
                            Utils.getReadLength(pictureType), occurs, Utils.getFloatingPointLength(pictureType),
                            redefinedItemName, getParent(level));
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
