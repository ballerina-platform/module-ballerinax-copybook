package io.ballerina.lib.copybook.commons.schema;

import java.util.List;

public class GroupItem implements CopybookNode {
    private final int level;
    private final String name;
    private final int occurs;
    private final boolean redefines;
    private final GroupItem parent;
    public List<CopybookNode> children;
    private final String redefinedItemName;

    public GroupItem(int level, String name, int occurs, boolean redefines, String redefinedItemName,
                     GroupItem parent) {
        this.level = level;
        this.name = name;
        this.occurs = occurs;
        this.parent = parent;
        this.redefines = redefines;
        this.children = new CopybookNodeList();
        this.redefinedItemName = redefinedItemName;
        if (parent != null) {
            this.parent.addChild(this);
        }
    }

    public void addChild(CopybookNode copybookNode) {
        this.children.add(copybookNode);
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public int getOccurringCount() {
        return this.occurs;
    }

    public GroupItem getParent() {
        return this.parent;
    }

    public List<CopybookNode> getChildren() {
        return this.children;
    }

    public String getRedefinedItemName() {
        return redefinedItemName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append("\"level\":").append(this.level).append(", \"name\":\"").append(this.name).append("\"")
                .append(", \"children\":").append(this.children);
        if (this.occurs > -1) {
            sb.append(", \"occurs\":").append(this.occurs);
        }
        sb.append("}");
        return sb.toString();
    }
}
