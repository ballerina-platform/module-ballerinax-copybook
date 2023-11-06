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

import ballerina/constraint;
import ballerina/file;
import ballerina/jballerina.java;

public isolated class Converter {
    private final Schema schema;

    public isolated function init(string schemaFilePath) returns error? {
        string absolutePath = check file:getAbsolutePath(schemaFilePath);
        self.schema = check parseSchemaFile(absolutePath);
    }

    public isolated function toJson(string copybookData, string? targetRecordName = ()) returns map<json>|error {
        lock {
            check self.validateTargetRecordName(targetRecordName);
            CopybookReader copybookReader = new (copybookData.iterator(), self.schema, targetRecordName);
            self.schema.accept(copybookReader);
            DataCoercer dataCoercer = new (self.schema, targetRecordName);
            return dataCoercer.coerce(copybookReader.getValue()).clone();
        }
    }

    public isolated function toCopybook(record {} input, string? targetRecordName = ()) returns string|error {
        readonly & map<json> readonlyJson = check input.cloneWithType();
        if readonlyJson.hasKey(ERRORS) {
            return error Error("Data coercion failed.", detail = readonlyJson.get(ERRORS));
        }
        lock {
            check self.validateTargetRecordName(targetRecordName);
            JsonToCopybookConvertor convertor = new (self.schema, targetRecordName);
            convertor.visitSchema(self.schema, readonlyJson);
            return convertor.getValue();
        }
    }

    private isolated function validateTargetRecordName(string? targetRecordName) returns error? {
        lock {
            if targetRecordName is () {
                if self.schema.getTypeDefinitions().length() == 1 {
                    return;
                }
                return error Error("The copybook schema has multiple record definitions. "
                    + "The targetRecordName must not be nil");
            }
            foreach Node node in self.schema.getTypeDefinitions() {
                if node.getName() == targetRecordName {
                    return;
                }
            }
            return error Error(string `Invalid target record name ${targetRecordName}`);
        }
    }

    public isolated function fromCopybook(string copybookData, string? targetRecordName = (), typedesc<record {}> t = <>) returns t|error = @java:Method {
        'class: "io.ballerina.lib.copybook.runtime.convertor.Utils"
    } external;

    private isolated function toRecord(string copybookData, typedesc<record {}> t, string? targetRecordName = ()) returns record {}|error {
        map<json> copybookJson = check self.toJson(copybookData, targetRecordName);
        return constraint:validate(copybookJson, t);
    }
}

isolated function parseSchemaFile(string schemaFilePath) returns Schema|Error = @java:Method {
    'class: "io.ballerina.lib.copybook.runtime.convertor.Utils"
} external;
