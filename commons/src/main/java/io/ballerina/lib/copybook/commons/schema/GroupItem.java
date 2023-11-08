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

import java.util.List;

public class GroupItem implements CopybookNode {
    private final int level;
    private final String name;
    private final int occurs;
    private final GroupItem parent;
    public List<CopybookNode> children;
    private final String redefinedItemName;

    public GroupItem(int level, String name, int occurs, String redefinedItemName,
                     GroupItem parent) {
        this.level = level;
        this.name = name;
        this.occurs = occurs;
        this.parent = parent;
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
        if (this.redefinedItemName != null) {
            sb.append(", \"redefinedItemName\": \"").append(this.redefinedItemName).append("\"");
        }
        sb.append("}");
        return sb.toString();
    }
}
