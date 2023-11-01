// Copyright (c) 2023 WSO2 LLC. (http://www.wso2.com) All Rights Reserved.
//
// WSO2 LLC. licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except
// in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

import ballerina/jballerina.java;

isolated function stringify(FieldValue fieldValue) returns string {
    if fieldValue is string {
        return fieldValue;
    }
    if fieldValue is string[] {
        return "".'join(...fieldValue);
    }
    if fieldValue is GroupValue {
        string[] groupFieldValues = [];
        foreach [string, anydata] [_, value] in fieldValue.entries() {
            if value !is FieldValue {
                continue;
            }
            groupFieldValues.push(stringify(value));
        }
        return "".'join(...groupFieldValues);
    }
    if fieldValue is GroupValue[] {
        string[] elements = [];
        foreach GroupValue item in fieldValue {
            elements.push(stringify(item));
        }
        return "".'join(...elements);
    }
    return "";
}

isolated function sanitize(GroupValue data) returns GroupValue {
    GroupValue sanitizedValue = {};
    foreach [string, anydata] [name, 'field] in data.entries() {
        if 'field is string {
            // Trim the trailing spaces to preserve spaces appeard in PIC X or PIC A
            string trimmedValue = trimRight('field);
            if 'field.trim() != "" {
                sanitizedValue[name] = trimmedValue;
            }
        } else if 'field is string[] {
            string[] sanitizedElements = [];
            foreach string fieldValue in 'field {
                string trimmedValue = trimRight(fieldValue);
                if fieldValue.trim() != "" {
                    sanitizedElements.push(trimmedValue);
                }
            }
            if sanitizedElements.length() > 0 {
                sanitizedValue[name] = sanitizedElements;
            }
        } else if 'field is GroupValue {
            GroupValue sanitizedGroup = sanitize('field);
            if sanitizedGroup.entries().length() > 0 {
                sanitizedValue[name] = sanitizedGroup;
            }
        } else if 'field is GroupValue[] {
            GroupValue[] sanitizedElements = [];
            foreach GroupValue groupValue in 'field {
                GroupValue santizedGroup = sanitize(groupValue);
                if santizedGroup.entries().length() > 0 {
                    sanitizedElements.push(santizedGroup);
                }
            }
            if sanitizedElements.length() > 0 {
                sanitizedValue[name] = sanitizedElements;
            }
        }
    }
    return sanitizedValue;
}

isolated function trimRight(string data) returns string {
    return re `\s+$`.replace(data, "");
}

isolated function computeSize(Node node, boolean withOccurence = true) returns int {
    int size = 0;
    if node is DataItem {
        size = node.getReadLength();
    } else if node is GroupItem {
        foreach var child in node.getChildren() {
            size += computeSize(child);
        }
    }
    int occuringTime = node.getElementCount();
    return withOccurence && occuringTime > 0 ? size * occuringTime : size;
}

isolated function isArray(Node item) returns boolean {
    if item is GroupItem {
        return item.getElementCount() != -1;
    } else if item is DataItem {
        return item.getElementCount() != -1;
    }
    return false;
}

isolated function decimalToString(decimal value) returns string {
    string decimalString = value.toString();
    int? seperatorIdx = decimalString.indexOf(".");
    if seperatorIdx is () {
        decimalString += ".0";
    }
    return decimalString;
}

isolated function externToString(Node node) returns string = @java:Method {
    'class: "io.ballerina.lib.convertor.Utils"
} external;
