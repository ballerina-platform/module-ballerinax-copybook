// Copyright (c) 2024 WSO2 LLC. (http://www.wso2.com) All Rights Reserved.
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

class DefaultValueCreator {
    *Visitor;
    private string[] defaultValueFragments = [];

    isolated function visitSchema(Schema schema, anydata data = ()) {
    }

    isolated function visitGroupItem(GroupItem groupItem, anydata data = ()) {
        if groupItem.getRedefinedItemName() is string {
            return;
        }
        string[] defaultValues = self.defaultValueFragments;
        self.defaultValueFragments = [];
        foreach Node node in groupItem.getChildren() {
            node.accept(self);
        }
        string groupItemDefaultValue = string:'join("", ...self.defaultValueFragments);
        defaultValues.push(self.generateRepeatedString(groupItemDefaultValue, groupItem.getElementCount()));
        self.defaultValueFragments = defaultValues;
    }

    isolated function visitDataItem(DataItem dataItem, anydata data = ()) {
        if dataItem.getRedefinedItemName() is string {
            return;
        }
        string dataItemDefaultValue = dataItem.getDefaulValue() ?: "";
        if (dataItem.isNumeric() && !dataItem.isDecimal()) ||  (dataItem.isDecimal() && dataItemDefaultValue != "") {
            dataItemDefaultValue = dataItemDefaultValue.padZero(dataItem.getReadLength());
        } else {
            dataItemDefaultValue = dataItemDefaultValue.padEnd(dataItem.getReadLength());
        }
        self.defaultValueFragments.push(self.generateRepeatedString(dataItemDefaultValue, dataItem.getElementCount()));
    }

    private isolated function generateRepeatedString(string value, int count) returns string {
        if count < 0 {
            return value;
        }
        string[] values = [];
        foreach int i in 1 ... count {
            values.push(value);
        }
        return string:'join("", ...values);
    }

    isolated function getDefaultValue() returns string {
        return string:'join("", ...self.defaultValueFragments);
    }
}
