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

# Represents copybook module related errors.
public type Error distinct error;

type Iterator object {
    public isolated function next() returns record {|byte value;|}?;
};

// Added as a workaround for https://github.com/ballerina-platform/ballerina-lang/issues/43301
isolated class ByteIterator {
    private final Iterator iterator;

    isolated function init(byte[] bytes) {
        self.iterator = bytes.cloneReadOnly().iterator();
    }

    isolated function next() returns record {|byte value;|}? {
        lock {
            return self.iterator.next().cloneReadOnly();
        }
    }
};

type GroupValue record {

};

type FieldValue string|string[]|GroupValue|GroupValue[];

type PrimitiveType string|int|float|decimal;

type PrimitiveArrayType string[]|int[]|float[]|decimal[];

const ROOT_JSON_PATH = "$";
const ERRORS = "errors";
const DATA = "data";

# Represents the encoding types used for the input or output byte arrays.
public enum Encoding {
    # Represents the ASCII encoding
    ASCII,
    # Represents the EBCDIC encoding
    EBCDIC
}
