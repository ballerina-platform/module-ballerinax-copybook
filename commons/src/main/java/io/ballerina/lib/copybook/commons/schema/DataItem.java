package io.ballerina.lib.copybook.commons.schema;

public class DataItem implements Node {
    private final int level;
    private final String name;
    private final String picture;
    private final boolean isNumeric;
    private final int occurs;
    private final int readLength;
    private final boolean isSinged;
    private final int floatingPointLength;
    private final String redefinedItemName;

    public DataItem(int level, String name, String picture, boolean isNumeric, int readLength, int occurs,
                    int floatingPointLength, String redefinedItemName, GroupItem parent) {
        this.level = level;
        this.name = name;
        this.picture = picture;
        this.isNumeric = isNumeric;
        this.readLength = readLength;
        this.occurs = occurs;
        this.isSinged = Utils.isSigned(picture);
        this.floatingPointLength = floatingPointLength;
        this.redefinedItemName = redefinedItemName;
        if (parent != null) {
            parent.addChild(this);
        }
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public String getPicture() {
        return this.picture;
    }

    public boolean isNumeric() {
        return this.isNumeric;
    }

    public int getOccurringCount() {
        return this.occurs;
    }

    public int getReadLength() {
        return this.readLength;
    }

    public boolean isSinged() {
        return this.isSinged;
    }

    public int getFloatingPointLength() {
        return this.floatingPointLength;
    }

    public String getRedefinedItemName() {
        return redefinedItemName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append("\"level\":").append(this.level).append(", \"name\":\"").append(this.name).append("\"")
                .append(", \"picture\":\"").append(this.picture).append("\"").append(", \"readLength\":")
                .append(this.readLength).append(", \"numeric\":").append(this.isNumeric);

        if (this.occurs > -1) {
            sb.append(", \"occurs\":").append(this.occurs);
        }
        if (this.isNumeric) {
            sb.append(", \"isSigned\":").append(this.isSinged);
        }
        if (this.floatingPointLength > 0) {
            sb.append(", \"floatingPointLength\":").append(this.floatingPointLength);
        }
        sb.append("}");
        return sb.toString();
    }
}
