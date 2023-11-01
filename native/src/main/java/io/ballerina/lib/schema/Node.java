package io.ballerina.lib.schema;

public interface Node {
    int getLevel();
    String getName();
    int getOccurringCount();
    String getRedefinedItemName();
}
