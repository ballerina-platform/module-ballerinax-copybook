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

import java.util.List;

import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataOccursClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.PictureCardinalityContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.PictureStringContext;

public final class Utils {
    private static final char ALPHA = 'A';
    private static final char ALPHA_NUMERIC = 'X';
    private static final String SING_INTEGER = "S";
    private static final String PLUS_SING = "+";
    private static final String MINUS_SIGN = "-";
    private static final String DECIMAL_SEPARATOR = ".";
    private static final String DECIMAL_SEPARATOR_V = "V";

    static boolean isNumeric(PictureStringContext pictureType) {
        char firstPicChar = pictureType.getText().toUpperCase().toCharArray()[0];
        return ALPHA != firstPicChar && ALPHA_NUMERIC != firstPicChar;
    }

    static boolean isSigned(String picture) {
        String firstPicChar = picture.substring(0, 1).toUpperCase();
        return SING_INTEGER.equals(firstPicChar);
    }

    static boolean hasPlusOrMinusPrefix(String picture) {
        String firstPicChar = picture.substring(0, 1).toUpperCase();
        return PLUS_SING.equals(firstPicChar) || MINUS_SIGN.equals(firstPicChar);
    }

    static int getReadLength(PictureStringContext pictureType) {
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

    static int getOccurringCount(DataOccursClauseContext occursClause) {
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

    static boolean isArray(DataOccursClauseContext occursClause) {
        return occursClause != null;
    }

    static int getFloatingPointLength(PictureStringContext pictureType) {
        String picture = pictureType.getText();
        int decimalPointIndex = picture.indexOf(DECIMAL_SEPARATOR);
        if (decimalPointIndex >= 0 && !picture.substring(decimalPointIndex).contains("(")) {
            return picture.length() - decimalPointIndex - 1;
        }
        int vIndex = picture.indexOf(DECIMAL_SEPARATOR_V);
        if (vIndex >= 0 && !picture.substring(vIndex).contains("(")) {
            return picture.length() - vIndex - 1;
        }

        List<PictureCardinalityContext> cardinalities = pictureType.pictureCardinality();
        if ((decimalPointIndex >= 0 || vIndex >= 0) && cardinalities.size() > 1) {
            return Integer.parseInt(cardinalities.get(cardinalities.size() - 1).integerLiteral().getText());
        }

        return 0;
    }
}
