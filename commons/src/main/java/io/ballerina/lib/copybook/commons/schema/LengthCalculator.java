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
        Matcher matcher = Pattern.compile("^.*\\.(?<fraction>9+)$").matcher(pictureString);
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
        Matcher matcher = Pattern.compile("^Z\\((?<suppressedZeros>\\d+)\\)(?<decimal>9+\\.9+)$")
                .matcher(pictureString);
        if (matcher.find()) {
            int suppressedCardinality = Integer.parseInt(matcher.group("suppressedZeros"));
            int decimalLength = matcher.group("decimal").length();
            return suppressedCardinality + decimalLength;
        }
        return 0;
    }
}
