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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schema {
    private final List<CopybookNode> typeDefinitions = new CopybookNodeList();
    private final Map<String, CopybookNode> redefinedItems = new HashMap<>();
    private final List<String> errors = new ArrayList<>();

    void addTypeDefinition(CopybookNode copybookNode) {
        this.typeDefinitions.add(copybookNode);
    }

    void addRedefinedItem(CopybookNode copybookNode) {
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

    void addErrors(List<String> errors) {
        this.errors.addAll(errors);
    }

    public List<String> getErrors() {
        return errors;
    }
}
