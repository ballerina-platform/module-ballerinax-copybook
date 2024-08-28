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

import ballerina/file;
import ballerina/jballerina.java;

# This class represents a copybook converter that facilitates the conversion of ASCII data to and from JSON data.
public isolated class Converter {
    private final Schema schema;

    # Initializes the converter with a schema.
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

    # Converts the provided record or map<json> value to bytes.
    # + input - The JSON value that needs to be converted as copybook data
    # + targetRecordName - The name of the copybook record definition in the copybook. This parameter must be a string
    # if the provided schema file contains more than one copybook record type definition
    # + encoding - The encoding of the output bytes array. Default is ASCII
    # + return - The converted byte array. In case of an error, a `copybook:Error` is is returned
    public isolated function toBytes(record {} input, string? targetRecordName = (), Encoding encoding = ASCII)
        returns byte[]|Error {
        readonly & map<json>|error readonlyJson = input.cloneWithType();
        if readonlyJson is error {
            return createError(readonlyJson);
        }
        check self.validateTargetRecordName(targetRecordName);
        lock {
            JsonToCopybookConverter converter = new (self.schema, targetRecordName, encoding);
            converter.visitSchema(self.schema, readonlyJson);
            byte[] bytes = check converter.getByteValue();
            return bytes.clone();
        }
    }

    # Converts the given copybook bytes to a Ballerina record.
    # + bytes - Bytes array that needs to be converted to a record value
    # + targetRecordName - The name of the copybook record definition in the copybook. This parameter must be a string
    # if the provided schema file contains more than one copybook record type definition
    # + encoding - The encoding of the input bytes array. Default is ASCII
    # + return - A record value on success, a `copybook:Error` in case of coercion errors
    public isolated function fromBytes(byte[] bytes, string? targetRecordName = (), Encoding encoding = ASCII)
        returns map<json>|Error {
        lock {
            check self.validateTargetRecordName(targetRecordName);
            CopybookReader copybookReader = new (bytes.clone(), self.schema, encoding, targetRecordName);
            self.schema.accept(copybookReader);
            DataCoercer dataCoercer = new (self.schema);
            Error[]? readerErrors = copybookReader.getErrors();
            dataCoercer.addErrors(readerErrors ?: []);
            return dataCoercer.coerce(copybookReader.getValue()).clone();
        }
    }

    private isolated function validateTargetRecordName(string? targetRecordName) returns Error? {
        lock {
            if targetRecordName is () {
                return;
            }
            foreach Node node in self.schema.getTypeDefinitions() {
                if node.getName() == targetRecordName {
                    return;
                }
            }
            return error Error(string `Invalid target record name '${targetRecordName}'`);
        }
    }
}

isolated function parseSchemaFile(string schemaFilePath) returns Schema|Error = @java:Method {
    'class: "io.ballerina.lib.copybook.runtime.converter.Utils"
} external;
