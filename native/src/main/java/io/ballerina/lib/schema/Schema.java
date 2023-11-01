package io.ballerina.lib.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schema {
    private final List<Node> typeDefinitions = new NodeList();
    private final Map<String, Node> redefinedItems = new HashMap<>();
    private final List<String> errors = new ArrayList<>();

    public void addTypeDefinition(Node node) {
        this.typeDefinitions.add(node);
    }

    public void addRedefinedItem(Node node) {
        this.redefinedItems.put(node.getName(), node);
    }

    public List<Node> getTypeDefinitions() {
        return typeDefinitions;
    }

    public Map<String, Node> getRedefinedItems() {
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
