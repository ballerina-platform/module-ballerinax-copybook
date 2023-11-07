package io.ballerina.lib.copybook.commons.schema;

import java.util.regex.Pattern;

class PictureStringValidator {

    private PictureStringValidator() {
    }

    static boolean isAlphaNumeric(String pictureString) {
        // ex: PIC XXX
        return Pattern.compile("^X+$").matcher(pictureString).find();
    }

    static boolean isInt(String pictureString) {
        // ex: PIC 999 or PIC +999 or PIC -999
        return Pattern.compile("^9+$").matcher(pictureString).find();
    }

    static boolean isDecimal(String pictureString) {
        // ex: PIC 99.99 or -99.99 or +99.99
        return Pattern.compile("^[+-]?9+.9+$").matcher(pictureString).find();
    }

    static boolean isAlphaNumericWithCardinality(String pictureString) {
        // ex: PIC X(9)
        return Pattern.compile("^X\\(\\d+\\)$").matcher(pictureString).find();
    }

    static boolean isIntWithCardinality(String pictureString) {
        // ex: PIC 9(2)
        return Pattern.compile("^9\\(\\d+\\)$").matcher(pictureString).find();
    }

    static boolean isSignRememberedIntWithCardinality(String pictureString) {
        // ex: PIC S9(2)
        return Pattern.compile("^S9\\(\\d+\\)$").matcher(pictureString).find();
    }

    static boolean isDecimalWithCardinality(String pictureString) {
        // ex: PIC 9(9).333
        return Pattern.compile("^[+-]?9\\(\\d+\\)\\.9+$").matcher(pictureString).find();
    }

    static boolean isDecimalWithSuppressedZeros(String pictureString) {
        // PIC Z(9)99.99
        return Pattern.compile("^Z\\(\\d+\\)9+.9+$").matcher(pictureString).find();
    }

    static boolean isSupportedPictureString(String pictureString) {
        return isAlphaNumeric(pictureString) || isInt(pictureString) || isDecimal(pictureString)
                || isAlphaNumericWithCardinality(pictureString) || isIntWithCardinality(pictureString)
                || isSignRememberedIntWithCardinality(pictureString) || isDecimalWithCardinality(pictureString)
                || isDecimalWithSuppressedZeros(pictureString);
    }
}
