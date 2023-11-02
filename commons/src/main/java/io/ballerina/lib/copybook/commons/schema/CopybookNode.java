package io.ballerina.lib.copybook.commons.schema;

public interface CopybookNode {
    int getLevel();
    String getName();
    int getOccurringCount();
    String getRedefinedItemName();
}
