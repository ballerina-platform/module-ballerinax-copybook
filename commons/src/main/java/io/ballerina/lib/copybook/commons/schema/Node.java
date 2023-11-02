package io.ballerina.lib.copybook.commons.schema;

public interface Node {
    int getLevel();
    String getName();
    int getOccurringCount();
    String getRedefinedItemName();
}
