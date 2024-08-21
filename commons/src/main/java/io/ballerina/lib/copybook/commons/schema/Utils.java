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

import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataOccursClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.DataUsageClauseContext;
import static io.ballerina.lib.copybook.commons.generated.CopybookParser.PictureStringContext;

public final class Utils {

    private Utils() {
    }

    static boolean isNumeric(PictureStringContext pictureType) {
        return !Pattern.compile("^[AX].*$").matcher(getPictureString(pictureType)).find();
    }

    static boolean isSigned(String picture) {
        return Pattern.compile("^S.*$").matcher(picture).find();
    }

    static int getReadLength(PictureStringContext pictureType) {
        return LengthCalculator.calculateReadLength(getPictureString(pictureType));
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

    static boolean isBinary(DataUsageClauseContext usageClause) {
        return usageClause != null && (usageClause.BINARY() != null || usageClause.COMP() != null);
    }

    static int getBinaryPackLength(int readLength) {
        if (readLength <= 4) {
            return 2;
        } else if (readLength <= 9) {
            return 4;
        }
        return 18;
    }

    static int getFloatingPointLength(PictureStringContext pictureType) {
        return LengthCalculator.calculateFractionLength(getPictureString(pictureType));
    }

    static String getPictureString(PictureStringContext pictureType) {
        return pictureType.getText().toUpperCase();
    }
}
