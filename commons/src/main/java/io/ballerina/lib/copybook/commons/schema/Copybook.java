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

import io.ballerina.lib.copybook.commons.generated.CopybookLexer;
import io.ballerina.lib.copybook.commons.generated.CopybookParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.IOException;

public class Copybook {
    private Copybook() {
    }

    public static Schema parse(String schemaPath) throws IOException {
        CopybookLexer lexer = new CopybookLexer(CharStreams.fromStream(new FileInputStream(schemaPath)));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CopybookParser parser = new CopybookParser(tokens);

        parser.removeErrorListeners();
        CopybookErrorListener errorListener = new CopybookErrorListener();
        parser.addErrorListener(errorListener);

        CopybookParser.StartRuleContext startRule = parser.startRule();
        SchemaBuilder visitor = new SchemaBuilder();
        startRule.accept(visitor);
        Schema schema = visitor.getSchema();
        schema.addErrors(errorListener.getErrors());
        return schema;
    }
}
