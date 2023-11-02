package io.ballerina.lib.copybook.commons.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schema {
    private final List<CopybookNode> typeDefinitions = new CopybookNodeList();
    private final Map<String, CopybookNode> redefinedItems = new HashMap<>();
    private final List<String> errors = new ArrayList<>();

    public void addTypeDefinition(CopybookNode copybookNode) {
        this.typeDefinitions.add(copybookNode);
    }

    public void addRedefinedItem(CopybookNode copybookNode) {
        this.redefinedItems.put(copybookNode.getName(), copybookNode);
    }

    public List<CopybookNode> getTypeDefinitions() {
        return typeDefinitions;
    }

    public Map<String, CopybookNode> getRedefinedItems() {
        return redefinedItems;
    }

    @Override
    public String toString() {
        return "{" + "\"schema\"" + ":" + typeDefinitions + "}";
    }

    public void setErrors(List<String> errors) {
        this.errors.addAll(errors);
    }

    public List<String> getErrors() {
        return errors;
    }
}
