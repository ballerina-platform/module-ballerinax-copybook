package io.ballerina.lib.copybook.commons.schema;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.ballerina.lib.copybook.commons.schema.PictureStringValidator.isAlphaNumeric;
import static io.ballerina.lib.copybook.commons.schema.PictureStringValidator.isAlphaNumericWithCardinality;
import static io.ballerina.lib.copybook.commons.schema.PictureStringValidator.isDecimal;
import static io.ballerina.lib.copybook.commons.schema.PictureStringValidator.isDecimalWithCardinality;
import static io.ballerina.lib.copybook.commons.schema.PictureStringValidator.isDecimalWithSuppressedZeros;
import static io.ballerina.lib.copybook.commons.schema.PictureStringValidator.isInt;
import static io.ballerina.lib.copybook.commons.schema.PictureStringValidator.isIntWithCardinality;
import static io.ballerina.lib.copybook.commons.schema.PictureStringValidator.isSignRememberedIntWithCardinality;

class LengthCalculator {

    private LengthCalculator() {
    }

    static int calculateFractionLength(String pictureString) {
        if (!isDecimal(pictureString) && !isDecimalWithCardinality(pictureString) && !isDecimalWithSuppressedZeros(
                pictureString)) {
            return 0;
        }
        Matcher matcher = Pattern.compile("^.*\\.(?<fraction>.9+)$").matcher(pictureString);
        if (matcher.find()) {
            return matcher.group("fraction").length();
        }
        return 0;
    }

    static int calculateReadLength(String pictureString) {
        if (isAlphaNumeric(pictureString) || isInt(pictureString) || isDecimal(pictureString)) {
            return pictureString.length();
        }

        if (isAlphaNumericWithCardinality(pictureString)) {
            return getReadLengthAlphaNumericWithCardinality(pictureString);
        }

        if (isIntWithCardinality(pictureString)) {
            return getReadLengthIntWithCardinality(pictureString);
        }

        if (isSignRememberedIntWithCardinality(pictureString)) {
            return getReadLengthSignRememberedIntWithCardinality(pictureString);
        }

        if (isDecimalWithCardinality(pictureString)) {
            return getReadLengthDecimalWithCardinality(pictureString);
        }

        if (isDecimalWithSuppressedZeros(pictureString)) {
            return getReadLengthDecimalWithSuppressedZeros(pictureString);
        }

        return 0;
    }

    private static int getReadLengthAlphaNumericWithCardinality(String pictureString) {
        Matcher matcher = Pattern.compile("^X\\((?<cardinality>\\d+)\\)$").matcher(pictureString);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group("cardinality"));
        }
        return 0;
    }

    private static int getReadLengthIntWithCardinality(String pictureString) {
        Matcher matcher = Pattern.compile("^9\\((?<cardinality>\\d+)\\)$").matcher(pictureString);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group("cardinality"));
        }
        return 0;
    }

    private static int getReadLengthSignRememberedIntWithCardinality(String pictureString) {
        Matcher matcher = Pattern.compile("^S9\\((?<cardinality>\\d+)\\)$").matcher(pictureString);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group("cardinality"));
        }
        return 0;
    }

    private static int getReadLengthDecimalWithCardinality(String pictureString) {
        Matcher matcher = Pattern.compile("^(?<sign>[+-])?9\\((?<cardinality>\\d+)\\)(?<fraction>\\.9+)$")
                .matcher(pictureString);
        if (matcher.find()) {
            String sign = matcher.group("sign");
            int singCount = sign != null ? sign.length() : 0;
            int integerCardinality = Integer.parseInt(matcher.group("cardinality"));
            // This fraction includes decimal separator "."
            int fractionLength = matcher.group("fraction").length();
            return singCount + integerCardinality + fractionLength;
        }
        return 0;
    }

    private static int getReadLengthDecimalWithSuppressedZeros(String pictureString) {
        Matcher matcher = Pattern.compile("^Z\\((?<suppressedZeros>\\d+)\\)(?<decimal>9+.9+)$").matcher(pictureString);
        if (matcher.find()) {
            int suppressedCardinality = Integer.parseInt(matcher.group("suppressedZeros"));
            int decimalLength = matcher.group("decimal").length();
            return suppressedCardinality + decimalLength;
        }
        return 0;
    }
}
