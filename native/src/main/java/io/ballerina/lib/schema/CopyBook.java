package io.ballerina.lib.schema;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.IOException;

public class CopyBook {
    private CopyBook() {
    }

    public static Schema parse(String schemaPath) throws IOException {
        CopyBookLexer lexer = new CopyBookLexer(CharStreams.fromStream(new FileInputStream(schemaPath)));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CopyBookParser parser = new CopyBookParser(tokens);

        parser.removeErrorListeners();
        CopyBookErrorListener errorListener = new CopyBookErrorListener();
        parser.addErrorListener(errorListener);

        CopyBookParser.StartRuleContext startRule = parser.startRule();
        SchemaBuilder visitor = new SchemaBuilder();
        startRule.accept(visitor);
        Schema schema = visitor.getSchema();
        schema.setErrors(errorListener.getErrors());
        return schema;
    }
}
