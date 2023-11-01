package io.ballerina.lib.schema;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.ballerina.lib.schema.CopyBookParser.BooleanLiteralContext;
import static io.ballerina.lib.schema.CopyBookParser.CicsDfhRespLiteralContext;
import static io.ballerina.lib.schema.CopyBookParser.CicsDfhValueLiteralContext;
import static io.ballerina.lib.schema.CopyBookParser.CobolWordContext;
import static io.ballerina.lib.schema.CopyBookParser.ConditionNameContext;
import static io.ballerina.lib.schema.CopyBookParser.DataBlankWhenZeroClauseContext;
import static io.ballerina.lib.schema.CopyBookParser.DataDescriptionContext;
import static io.ballerina.lib.schema.CopyBookParser.DataDescriptionEntryClausesContext;
import static io.ballerina.lib.schema.CopyBookParser.DataDescriptionEntryContext;
import static io.ballerina.lib.schema.CopyBookParser.DataDescriptionEntryFormat1Context;
import static io.ballerina.lib.schema.CopyBookParser.DataDescriptionEntryFormat2Context;
import static io.ballerina.lib.schema.CopyBookParser.DataDescriptionEntryFormat3Context;
import static io.ballerina.lib.schema.CopyBookParser.DataExternalClauseContext;
import static io.ballerina.lib.schema.CopyBookParser.DataGlobalClauseContext;
import static io.ballerina.lib.schema.CopyBookParser.DataJustifiedClauseContext;
import static io.ballerina.lib.schema.CopyBookParser.DataNameContext;
import static io.ballerina.lib.schema.CopyBookParser.DataOccursClauseContext;
import static io.ballerina.lib.schema.CopyBookParser.DataOccursSortContext;
import static io.ballerina.lib.schema.CopyBookParser.DataOccursToContext;
import static io.ballerina.lib.schema.CopyBookParser.DataPictureClauseContext;
import static io.ballerina.lib.schema.CopyBookParser.DataRedefinesClauseContext;
import static io.ballerina.lib.schema.CopyBookParser.DataRenamesClauseContext;
import static io.ballerina.lib.schema.CopyBookParser.DataSignClauseContext;
import static io.ballerina.lib.schema.CopyBookParser.DataSynchronizedClauseContext;
import static io.ballerina.lib.schema.CopyBookParser.DataUsageClauseContext;
import static io.ballerina.lib.schema.CopyBookParser.DataValueClauseContext;
import static io.ballerina.lib.schema.CopyBookParser.DataValueIntervalContext;
import static io.ballerina.lib.schema.CopyBookParser.DataValueIntervalFromContext;
import static io.ballerina.lib.schema.CopyBookParser.DataValueIntervalToContext;
import static io.ballerina.lib.schema.CopyBookParser.FigurativeConstantContext;
import static io.ballerina.lib.schema.CopyBookParser.IdentifierContext;
import static io.ballerina.lib.schema.CopyBookParser.IndexNameContext;
import static io.ballerina.lib.schema.CopyBookParser.IntegerLiteralContext;
import static io.ballerina.lib.schema.CopyBookParser.LiteralContext;
import static io.ballerina.lib.schema.CopyBookParser.NumericLiteralContext;
import static io.ballerina.lib.schema.CopyBookParser.PictureCardinalityContext;
import static io.ballerina.lib.schema.CopyBookParser.PictureCharsContext;
import static io.ballerina.lib.schema.CopyBookParser.PictureStringContext;
import static io.ballerina.lib.schema.CopyBookParser.QualifiedDataNameContext;
import static io.ballerina.lib.schema.CopyBookParser.StartRuleContext;

public class SchemaBuilder implements CopyBookVisitor<Node> {
    private final Schema schema = new Schema();
    private GroupItem possibleParent;
    private final Set<String> redefinedItemNames = new HashSet<>();
    private final List<String> errors = new ArrayList<>(); // TODO: check for redfinedItems in tree and put errors if
    // not exisits

    public Schema getSchema() {
        return this.schema;
    }

    @Override
    public Node visitStartRule(StartRuleContext ctx) {
        this.possibleParent = null;
        visitDataDescription(ctx.dataDescription());
        for (Node typedef : schema.getTypeDefinitions()) {
            addRedefinedItems(typedef);
        }
        return null;
    }

    private void addRedefinedItems(Node item) {
        if (this.redefinedItemNames.contains(item.getName())) {
            this.schema.addRedefinedItem(item);
            return;
        }
        if (item instanceof GroupItem) {
            ((GroupItem) item).getChildren().forEach(this::addRedefinedItems);
        }
    }

    @Override
    public Node visitDataDescription(DataDescriptionContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            Node node = visitDataDescriptionEntry(ctx.dataDescriptionEntry(i));
            if (node instanceof GroupItem) {
                this.possibleParent = (GroupItem) node;
            }
            if (isRootLevelNode(node)) {
                this.schema.addTypeDefinition(node);
            }
        }
        return null;
    }

    private boolean isRootLevelNode(Node node) {
        return node != null && node.getLevel() == 1;
    }

    @Override
    public Node visitDataDescriptionEntry(DataDescriptionEntryContext ctx) {
        if (ctx.dataDescriptionEntryFormat1() != null) {
            return visitDataDescriptionEntryFormat1(ctx.dataDescriptionEntryFormat1());
        }
        // skipping level 66 and 88
        return null;
    }

    @Override
    public Node visitDataDescriptionEntryFormat1(DataDescriptionEntryFormat1Context ctx) {
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
    public Node visitDataDescriptionEntryClauses(DataDescriptionEntryClausesContext ctx) {
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
    public Node visitDataDescriptionEntryFormat2(DataDescriptionEntryFormat2Context ctx) {
        return null;
    }

    @Override
    public Node visitDataDescriptionEntryFormat3(DataDescriptionEntryFormat3Context ctx) {
        return null;
    }

    @Override
    public Node visitDataBlankWhenZeroClause(DataBlankWhenZeroClauseContext ctx) {
        return null;
    }

    @Override
    public Node visitDataExternalClause(DataExternalClauseContext ctx) {
        return null;
    }

    @Override
    public Node visitDataGlobalClause(DataGlobalClauseContext ctx) {
        return null;
    }

    @Override
    public Node visitDataJustifiedClause(DataJustifiedClauseContext ctx) {
        return null;
    }

    @Override
    public Node visitDataOccursClause(DataOccursClauseContext ctx) {
        return null;
    }

    @Override
    public Node visitDataOccursTo(DataOccursToContext ctx) {
        return null;
    }

    @Override
    public Node visitDataOccursSort(DataOccursSortContext ctx) {
        return null;
    }

    @Override
    public Node visitDataPictureClause(DataPictureClauseContext ctx) {
        return null;
    }

    @Override
    public Node visitPictureString(PictureStringContext ctx) {
        return null;
    }

    @Override
    public Node visitPictureChars(PictureCharsContext ctx) {
        return null;
    }

    @Override
    public Node visitPictureCardinality(PictureCardinalityContext ctx) {
        return null;
    }

    @Override
    public Node visitDataRedefinesClause(DataRedefinesClauseContext ctx) {
        return null;
    }

    @Override
    public Node visitDataRenamesClause(DataRenamesClauseContext ctx) {
        return null;
    }

    @Override
    public Node visitDataSignClause(DataSignClauseContext ctx) {
        return null;
    }

    @Override
    public Node visitDataSynchronizedClause(DataSynchronizedClauseContext ctx) {
        return null;
    }

    @Override
    public Node visitDataUsageClause(DataUsageClauseContext ctx) {
        return null;
    }

    @Override
    public Node visitDataValueClause(DataValueClauseContext ctx) {
        return null;
    }

    @Override
    public Node visitDataValueInterval(DataValueIntervalContext ctx) {
        return null;
    }

    @Override
    public Node visitDataValueIntervalFrom(DataValueIntervalFromContext ctx) {
        return null;
    }

    @Override
    public Node visitDataValueIntervalTo(DataValueIntervalToContext ctx) {
        return null;
    }

    @Override
    public Node visitIdentifier(IdentifierContext ctx) {
        return null;
    }

    @Override
    public Node visitQualifiedDataName(QualifiedDataNameContext ctx) {
        return null;
    }

    @Override
    public Node visitConditionName(ConditionNameContext ctx) {
        return null;
    }

    @Override
    public Node visitDataName(DataNameContext ctx) {
        return null;
    }

    @Override
    public Node visitIndexName(IndexNameContext ctx) {
        return null;
    }

    @Override
    public Node visitCobolWord(CobolWordContext ctx) {
        return null;
    }

    @Override
    public Node visitLiteral(LiteralContext ctx) {
        return null;
    }

    @Override
    public Node visitBooleanLiteral(BooleanLiteralContext ctx) {
        return null;
    }

    @Override
    public Node visitNumericLiteral(NumericLiteralContext ctx) {
        return null;
    }

    @Override
    public Node visitIntegerLiteral(IntegerLiteralContext ctx) {
        return null;
    }

    @Override
    public Node visitCicsDfhRespLiteral(CicsDfhRespLiteralContext ctx) {
        return null;
    }

    @Override
    public Node visitCicsDfhValueLiteral(CicsDfhValueLiteralContext ctx) {
        return null;
    }

    @Override
    public Node visitFigurativeConstant(FigurativeConstantContext ctx) {
        return null;
    }

    @Override
    public Node visit(ParseTree tree) {
        return null;
    }

    @Override
    public Node visitChildren(RuleNode node) {
        return null;
    }

    @Override
    public Node visitTerminal(TerminalNode node) {
        return null;
    }

    @Override
    public Node visitErrorNode(ErrorNode node) {
        return null;
    }
}
