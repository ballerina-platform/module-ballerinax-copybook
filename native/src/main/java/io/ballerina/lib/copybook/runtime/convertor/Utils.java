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

package io.ballerina.lib.copybook.runtime.convertor;

import io.ballerina.lib.copybook.commons.schema.Copybook;
import io.ballerina.lib.copybook.commons.schema.CopybookNode;
import io.ballerina.lib.copybook.commons.schema.DataItem;
import io.ballerina.lib.copybook.commons.schema.GroupItem;
import io.ballerina.lib.copybook.commons.schema.Schema;
import io.ballerina.runtime.api.Environment;
import io.ballerina.runtime.api.Future;
import io.ballerina.runtime.api.PredefinedTypes;
import io.ballerina.runtime.api.creators.ErrorCreator;
import io.ballerina.runtime.api.creators.TypeCreator;
import io.ballerina.runtime.api.creators.ValueCreator;
import io.ballerina.runtime.api.types.ArrayType;
import io.ballerina.runtime.api.types.MapType;
import io.ballerina.runtime.api.types.ObjectType;
import io.ballerina.runtime.api.utils.StringUtils;
import io.ballerina.runtime.api.values.BArray;
import io.ballerina.runtime.api.values.BError;
import io.ballerina.runtime.api.values.BMap;
import io.ballerina.runtime.api.values.BObject;
import io.ballerina.runtime.api.values.BString;
import io.ballerina.runtime.api.values.BTypedesc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.ballerina.lib.copybook.runtime.convertor.ModuleUtils.getModule;

public final class Utils {

    private static final String NATIVE_VALUE = "native-value";
    private static final String TO_RECORD_METHOD_NAME = "toRecord";
    private static final String NODE_TYPE_NAME = "Node";
    private static final String SCHEMA_TYPE_NAME = "Schema";
    private static final String GROUP_ITEM_TYPE_NAME = "GroupItem";
    private static final String DATA_ITEM_TYPE_NAME = "DataItem";
    private static final String ERROR_TYPE_NAME = "Error";

    private Utils() {
    }

    public static Object parseSchemaFile(BString schemaPath) {
        BObject schema = ValueCreator.createObjectValue(getModule(), SCHEMA_TYPE_NAME);
        try {
            Schema nativeSchema = Copybook.parse(schemaPath.getValue());
            if (!nativeSchema.getErrors().isEmpty()) {
                return handleParsingError(nativeSchema);
            }
            schema.addNativeData(NATIVE_VALUE, nativeSchema);
            return schema;
        } catch (IOException e) {
            return createError(e.getMessage());
        }
    }

    private static BError handleParsingError(Schema nativeSchema) {
        BString[] bStrings = nativeSchema.getErrors().stream().map(StringUtils::fromString).toArray(BString[]::new);
        BArray errors = ValueCreator.createArrayValue(bStrings);
        BMap<BString, Object> errorDetail = ValueCreator.createMapValue();
        errorDetail.put(StringUtils.fromString("parser-errors"), errors);
        return createError("Error while parsing the Copybook schema.", errorDetail);
    }


    private static BError createError(String message, BMap<BString, Object> errorDetail) {
        return ErrorCreator.createError(getModule(), ERROR_TYPE_NAME, StringUtils.fromString(message), null,
                                        errorDetail);
    }

    private static BError createError(String message) {
        return createError(message, null);
    }


    public static int getLevel(BObject bObject) {
        CopybookNode copybookNode = (CopybookNode) bObject.getNativeData(NATIVE_VALUE);
        return copybookNode.getLevel();
    }

    public static BString getName(BObject bObject) {
        CopybookNode copybookNode = (CopybookNode) bObject.getNativeData(NATIVE_VALUE);
        return StringUtils.fromString(copybookNode.getName());
    }

    public static Object getRedefinedItemName(BObject bObject) {
        CopybookNode copybookNode = (CopybookNode) bObject.getNativeData(NATIVE_VALUE);
        return copybookNode.getRedefinedItemName() == null ? null :
                StringUtils.fromString(copybookNode.getRedefinedItemName());
    }

    public static boolean isNumeric(BObject bObject) {
        DataItem dataItem = (DataItem) bObject.getNativeData(NATIVE_VALUE);
        return dataItem.isNumeric();
    }

    public static boolean isSigned(BObject bObject) {
        DataItem dataItem = (DataItem) bObject.getNativeData(NATIVE_VALUE);
        return dataItem.isSinged();
    }

    public static BString getPicture(BObject bObject) {
        DataItem dataItem = (DataItem) bObject.getNativeData(NATIVE_VALUE);
        return StringUtils.fromString(dataItem.getPicture());
    }

    public static int getReadLength(BObject bObject) {
        DataItem dataItem = (DataItem) bObject.getNativeData(NATIVE_VALUE);
        return dataItem.getReadLength();
    }

    public static int getElementCount(BObject bObject) {
        CopybookNode nod = (CopybookNode) bObject.getNativeData(NATIVE_VALUE);
        return nod.getOccurringCount();
    }

    public static BString externToString(BObject bObject) {
        Object nativeData = bObject.getNativeData(NATIVE_VALUE);
        return StringUtils.fromString(nativeData.toString());
    }

    public static int getFloatingPointLength(BObject bObject) {
        DataItem dataItem = (DataItem) bObject.getNativeData(NATIVE_VALUE);
        return dataItem.getFloatingPointLength();
    }

    public static BArray getChildren(BObject bObject) {
        GroupItem groupItem = (GroupItem) bObject.getNativeData(NATIVE_VALUE);
        List<BObject> children = new ArrayList<>();
        for (CopybookNode child : groupItem.getChildren()) {
            BObject element = child instanceof GroupItem ?
                    ValueCreator.createObjectValue(getModule(), GROUP_ITEM_TYPE_NAME) :
                    ValueCreator.createObjectValue(getModule(), DATA_ITEM_TYPE_NAME);
            element.addNativeData(NATIVE_VALUE, child);
            children.add(element);
        }
        ObjectType elementType = TypeCreator.createObjectType(NODE_TYPE_NAME, getModule(), 0);
        ArrayType arrayType = TypeCreator.createArrayType(elementType);
        return ValueCreator.createArrayValue(children.toArray(), arrayType);
    }

    public static BArray getTypeDefinitions(BObject bObject) {
        Schema schema = (Schema) bObject.getNativeData(NATIVE_VALUE);
        List<BObject> children = new ArrayList<>();
        for (CopybookNode child : schema.getTypeDefinitions()) {
            BObject element = child instanceof GroupItem ?
                    ValueCreator.createObjectValue(getModule(), GROUP_ITEM_TYPE_NAME) :
                    ValueCreator.createObjectValue(getModule(), DATA_ITEM_TYPE_NAME);
            element.addNativeData(NATIVE_VALUE, child);
            children.add(element);
        }
        ObjectType elementType = TypeCreator.createObjectType(NODE_TYPE_NAME, getModule(), 0);
        ArrayType arrayType = TypeCreator.createArrayType(elementType);
        return ValueCreator.createArrayValue(children.toArray(), arrayType);
    }

    public static BMap<BString, Object> getRedefinedItems(BObject bObject) {
        Schema schema = (Schema) bObject.getNativeData(NATIVE_VALUE);
        ObjectType constraintType = TypeCreator.createObjectType(NODE_TYPE_NAME, getModule(), 0);
        MapType mapType = TypeCreator.createMapType(constraintType);
        BMap<BString, Object> bMap = ValueCreator.createMapValue(mapType);
        for (CopybookNode child : schema.getRedefinedItems().values()) {
            BObject element = child instanceof GroupItem ?
                    ValueCreator.createObjectValue(getModule(), GROUP_ITEM_TYPE_NAME) :
                    ValueCreator.createObjectValue(getModule(), DATA_ITEM_TYPE_NAME);
            element.addNativeData(NATIVE_VALUE, child);
            bMap.put(StringUtils.fromString(child.getName()), element);
        }
        return bMap;
    }

    public static BArray getDataDescriptions(BObject bObject) {
        Schema schema = (Schema) bObject.getNativeData(NATIVE_VALUE);
        List<BObject> children = new ArrayList<>();
        for (CopybookNode child : schema.getTypeDefinitions()) {
            BObject element = child instanceof GroupItem ?
                    ValueCreator.createObjectValue(getModule(), GROUP_ITEM_TYPE_NAME) :
                    ValueCreator.createObjectValue(getModule(), DATA_ITEM_TYPE_NAME);
            element.addNativeData(NATIVE_VALUE, child);
            children.add(element);
        }
        ObjectType elementType = TypeCreator.createObjectType(NODE_TYPE_NAME, getModule(), 0);
        ArrayType arrayType = TypeCreator.createArrayType(elementType);
        return ValueCreator.createArrayValue(children.toArray(), arrayType);
    }

    public static boolean hasRedefinedItems(BObject bObject, BString name) {
        Schema schema = (Schema) bObject.getNativeData(NATIVE_VALUE);
        return schema.getRedefinedItems().containsKey(name.getValue());
    }

    public static Object fromCopybook(Environment env, BObject convertor, BString copybookData, Object targetRecordName,
                                      BTypedesc typedesc) {
        Future balFuture = env.markAsync();
        ExecutionCallback callback = new ExecutionCallback(balFuture);
        Object[] paramFeed = {copybookData, true, typedesc, true, targetRecordName, true};
        env.getRuntime().invokeMethodAsyncConcurrently(convertor, TO_RECORD_METHOD_NAME, null, null, callback, null,
                                                       PredefinedTypes.TYPE_NULL, paramFeed);
        return null;
    }
}
