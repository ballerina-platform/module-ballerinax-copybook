package io.ballerina.lib.copybook.commons.schema;

import io.ballerina.lib.copybook.commons.generated.CopyBookLexer;
import io.ballerina.lib.copybook.commons.generated.CopyBookParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CopyBook {

    private static PrintStream out = System.out;

    private CopyBook() {
    }

    public static Schema parse(String schemaPath) throws IOException {
        CopyBookLexer lexer = new CopyBookLexer(CharStreams.fromStream(new FileInputStream(schemaPath)));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CopyBookParser parser = new CopyBookParser(tokens);

        parser.removeErrorListeners();
        CopyBookErrorListener errorListener = new CopyBookErrorListener();
        parser.addErrorListener(errorListener);

        try {
            FileOutputStream fos = new FileOutputStream(new File("output.txt"));
        } catch (Exception e) {
            out.println("Exception: " + e.getMessage());
        }

        CopyBookParser.StartRuleContext startRule = parser.startRule();
        SchemaBuilder visitor = new SchemaBuilder();
        startRule.accept(visitor);
        Schema schema = visitor.getSchema();
        schema.setErrors(errorListener.getErrors());
        return schema;
    }
}
