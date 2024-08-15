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
import java.util.List;

public class DataItem implements CopybookNode {
    private final int level;
    private final String name;
    private final String picture;
    private final boolean isNumeric;
    private final int occurs;
    private final int readLength;
    private final boolean isSinged;
    private final int floatingPointLength;
    private final String redefinedItemName;
    private final ArrayList<String> possibleEnumValues = new ArrayList<>();

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

    public boolean isEnum() {
        return !this.possibleEnumValues.isEmpty();
    }

    public List<String> getPossibleEnumValues() {
        return this.possibleEnumValues;
    }

    public int getFloatingPointLength() {
        return this.floatingPointLength;
    }

    public String getRedefinedItemName() {
        return redefinedItemName;
    }

    void addEnumValues(String enumValue) {
        this.possibleEnumValues.add(enumValue);
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
        if (this.redefinedItemName != null) {
            sb.append(", \"redefinedItemName\": \"").append(this.redefinedItemName).append("\"");
        }
        if (this.isEnum()) {
            sb.append(", \"isEnum\": true");
            sb.append(",  \"enumValues\":").append("[");
            int i = 0;
            for (String value : this.possibleEnumValues) {
                sb.append("\"");
                sb.append(value);
                sb.append("\"");
                i++;
                if (i != this.possibleEnumValues.size()) {
                    sb.append(",");
                }
            }
            sb.append("]");
        }
        sb.append("}");
        return sb.toString();
    }
}
