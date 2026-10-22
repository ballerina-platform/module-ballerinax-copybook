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

// The visit methods take a Node (not the concrete item classes) to avoid a cyclic Node/Visitor/item type dependency
// that fails to type check on recent Ballerina versions (2201.14).
type Visitor distinct object {
    isolated function visitSchema(Node visited, anydata data = ());
    isolated function visitGroupItem(Node visited, anydata data = ());
    isolated function visitDataItem(Node visited, anydata data = ());
    public isolated function getErrors() returns Error[]?;
};
