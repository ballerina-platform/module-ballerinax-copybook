package io.ballerina.lib.schema;

import java.util.List;

public class Utils {
    private static final String ALPHA = "A";
    private static final String ALPHA_NUMERIC = "X";
    private static final String SING_INTEGER = "S";
    private static final String PLUS_SING = "+";
    private static final String MINUS_SIGN = "-";
    private static final String DECIMAL_SEPARATOR = ".";
    private static final String DECIMAL_SEPARATOR_V = "V";

    public static boolean isNumeric(CopyBookParser.PictureStringContext pictureType) {
        String firstPicChar = pictureType.pictureChars(0).getText().toUpperCase();
        return !ALPHA.equals(firstPicChar) && !ALPHA_NUMERIC.equals(firstPicChar);
    }

    public static boolean isSigned(String picture) {
        String firstPicChar = picture.substring(0, 1).toUpperCase();
        return SING_INTEGER.equals(firstPicChar);
    }

    public static boolean hasPlusOrMinusPrefix(String picture) {
        String firstPicChar = picture.substring(0, 1).toUpperCase();
        return PLUS_SING.equals(firstPicChar) || MINUS_SIGN.equals(firstPicChar);
    }

    public static int getReadLength(CopyBookParser.PictureStringContext pictureType) {
        // TODO: this implementation doesn't check complex cases with more than one cardinality ex: z(9)9(9).3(9)
        String picture = pictureType.getText();
        if (pictureType.pictureCardinality(0) == null) {
            // also counts +/- sing for length
            // TODO: if this has the format 5V10 then should remove V from it
            return picture.trim().length();
        }

        // temporary fix z(9)9.3(9)
        int moreWholePart = 0;
        if (picture.contains("Z")) {
            int firstCloseParIndex = picture.indexOf(')');
            if (firstCloseParIndex > 0 && firstCloseParIndex + 1 < picture.length() - 1) {
                for (char c : picture.substring(firstCloseParIndex + 1).toCharArray()) {
                    if (c == '.' || c == 'V') {
                        break;
                    }
                    moreWholePart++;
                }
            }
        }

        // TODO: if this has the format 5(9)V10 then should remove V from it
        int wholeNumberCardinality = Integer.parseInt(pictureType.pictureCardinality(0).integerLiteral().getText());
        int signCount = hasPlusOrMinusPrefix(picture) ? 1 : 0;
        int decimalCardinality = Utils.getFloatingPointLength(pictureType);
        // Add 1 for decimal separator char  '.'
        boolean hasDotSeparator = picture.contains(DECIMAL_SEPARATOR);
        return wholeNumberCardinality + decimalCardinality + signCount + (hasDotSeparator ? 1 : 0) + moreWholePart;
    }

    public static int getOccurringCount(CopyBookParser.DataOccursClauseContext occursClause) {
        if (!isArray(occursClause)) {
            return -1;
        }
        int fromCount = Integer.parseInt(occursClause.integerLiteral().getText());
        if (occursClause.dataOccursTo() == null) {
            return fromCount;
        }
        int toCount = Integer.parseInt(occursClause.dataOccursTo().integerLiteral().getText());
        return Integer.max(fromCount, toCount);
    }

    private static boolean isArray(CopyBookParser.DataOccursClauseContext occursClause) {
        return occursClause != null;
    }

    public static int getFloatingPointLength(CopyBookParser.PictureStringContext pictureType) {
        String picture = pictureType.getText();
        int decimalPointIndex = picture.indexOf(DECIMAL_SEPARATOR);
        if (decimalPointIndex >= 0 && !picture.substring(decimalPointIndex).contains("(")) {
            return picture.length() - decimalPointIndex - 1;
        }
        int vIndex = picture.indexOf(DECIMAL_SEPARATOR_V);
        if (vIndex >= 0 && !picture.substring(vIndex).contains("(")) {
            return picture.length() - vIndex - 1;
        }

        List<CopyBookParser.PictureCardinalityContext> cardinalities = pictureType.pictureCardinality();
        if ((decimalPointIndex >= 0 || vIndex >= 0) && cardinalities.size() > 1) {
            return Integer.parseInt(cardinalities.get(cardinalities.size() - 1).integerLiteral().getText());
        }

        return 0;
    }
}
