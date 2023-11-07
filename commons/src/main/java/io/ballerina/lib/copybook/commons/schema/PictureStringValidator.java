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
