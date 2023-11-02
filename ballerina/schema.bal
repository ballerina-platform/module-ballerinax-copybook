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

distinct class Schema {
    *Node;

    isolated function getLevel() returns int {
        return 0;
    }

    isolated function getName() returns string {
        return "$chema";
    };

    isolated function getElementCount() returns int {
        return -1;
    }

    isolated function getTypeDefinitions() returns Node[] = @java:Method {
        'class: "io.ballerina.lib.copybook.runtime.convertor.Utils"
    } external;

    isolated function getRedefinedItems() returns map<Node> = @java:Method {
        'class: "io.ballerina.lib.copybook.runtime.convertor.Utils"
    } external;

    isolated function accept(Visitor visitor) {
        visitor.visitSchema(self);
    }

    isolated function toString() returns string {
        return externToString(self);
    }
}
