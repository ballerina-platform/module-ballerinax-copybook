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

# This class represents a copybook convertor that facilitates the conversion of ASCII data to and from JSON data.
public isolated class Convertor {
    private final Schema schema;

    # Initializes the convertor with a schema.
    # + schemaFilePath - The path of the copybook file
    # + return - `copybook:Error` on failure, Nil otherwise
    public isolated function init(string schemaFilePath) returns Error? {
        do {
            string absolutePath = check file:getAbsolutePath(schemaFilePath);
            self.schema = check parseSchemaFile(absolutePath);
        } on fail error err {
            return createError(err);
        }
    }

    # Converts the given ASCII string to a JSON value.
    # + copybookData - The ASCII string that needs to be converted to JSON
    # + targetRecordName - The name of the copybook record definition in the copybook. This parameter must be a string
    # if the provided schema file contains more than one copybook record type definition
    # + return - A JSON value in the following formats: `{data: converted-json-value}` 
    # or `{data: partial-converted-json-value, errors: [list of coercion errors]}`. In case of an error, a 
    # `copybook:Error` is returned
    public isolated function toJson(string copybookData, string? targetRecordName = ()) returns map<json>|Error {
        lock {
            check self.validateTargetRecordName(targetRecordName);
            CopybookReader copybookReader = new (copybookData.iterator(), self.schema, targetRecordName);
            self.schema.accept(copybookReader);
            DataCoercer dataCoercer = new (self.schema, targetRecordName);
            return dataCoercer.coerce(copybookReader.getValue()).clone();
        }
    }

    # Converts the provided record or map<json> value to ASCII data.
    # + input - The JSON value that needs to be converted as copybook data
    # + targetRecordName - The name of the copybook record definition in the copybook. This parameter must be a string
    # if the provided schema file contains more than one copybook record type definition
    # + return - The converted ASCII string. In case of an error, a `copybook:Error` is is returned
    public isolated function toCopybook(record {} input, string? targetRecordName = ()) returns string|Error {
        do {
            readonly & map<json> readonlyJson = check input.cloneWithType();
            lock {
                check self.validateTargetRecordName(targetRecordName);
                JsonToCopybookConvertor convertor = new (self.schema, targetRecordName);
                convertor.visitSchema(self.schema, readonlyJson);
                return convertor.getValue();
            }
        } on fail error err {
            return createError(err);
        }
    }

    private isolated function validateTargetRecordName(string? targetRecordName) returns Error? {
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

    # Converts the given ASCII string to a Ballerina record.
    # + copybookData - The ASCII string that needs to be converted to a record value
    # + targetRecordName - The name of the copybook record definition in the copybook. This parameter must be a string
    # if the provided schema file contains more than one copybook record type definition
    # + t - The type of the target record type
    # + return - A record value on success, a `copybook:Error` in case of coercion errors
    public isolated function fromCopybook(string copybookData, string? targetRecordName = (), typedesc<record {}> t = <>) returns t|Error = @java:Method {
        'class: "io.ballerina.lib.copybook.runtime.convertor.Utils"
    } external;

    private isolated function toRecord(string copybookData, typedesc<record {}> t, string? targetRecordName = ()) returns record {}|Error {
        do {
            map<json> copybookJson = check self.toJson(copybookData, targetRecordName);
            if copybookJson.hasKey(ERRORS) {
                return error Error("Data coercion failed.", detail = copybookJson.get(ERRORS));
            }
            return check constraint:validate(copybookJson.get(DATA), t);
        } on fail error err {
            return createError(err);
        }
    }
}

isolated function parseSchemaFile(string schemaFilePath) returns Schema|Error = @java:Method {
    'class: "io.ballerina.lib.copybook.runtime.convertor.Utils"
} external;
