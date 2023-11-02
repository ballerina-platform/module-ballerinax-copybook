package io.ballerina.lib.copybook.commons.schema;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

public class CopyBookErrorListener extends BaseErrorListener {
    private final List<String> errors = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        this.errors.add("Error at line " + line + ", column " + charPositionInLine + ": " + msg);
    }

    public List<String> getErrors() {
        return this.errors;
    }
}
