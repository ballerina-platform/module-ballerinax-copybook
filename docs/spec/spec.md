# Specification: Ballerina Copybook Library

_Owners_: @MohamedSabthar @DimuthuMadushan \
_Reviewers_: @ThisaruGuruge \
_Created_: 2023/11/16 \
_Updated_: 2023/11/16 \
_Edition_: Swan Lake

## Introduction
The Ballerina Copybook module is designed to effortlessly manage the conversion of Copybook data structures to JSON and the reverse, as well as the conversion of Copybook ASCII to a specified Ballerina Record.

The Copybook library specification has evolved and may continue to evolve in the future. The released versions of the specification can be found under the relevant GitHub tag.

If you have any feedback or suggestions about the library, start a discussion via a [GitHub issue](https://github.com/ballerina-platform/ballerina-library/issues) or in the [Discord server](https://discord.gg/ballerinalang). Based on the outcome of the discussion, the specification and implementation can be updated. Community feedback is always welcome. Any accepted proposal, which affects the specification is stored under `/docs/proposals`. Proposals under discussion can be found with the label `type/proposal` in GitHub.

The conforming implementation of the specification is released and included in the distribution. Any deviation from the specification is considered a bug.

## Contents

1. [Overview](#1-overview)
2. [Initialize the Copybook Converter](#2-initialize-the-copybook-converter)
    * 2.1 [The `init` Method](#21-the-init-method)
3. [Convert Copybook ASCII to JSON](#3-convert-copybook-ascii-to-json)
    * 3.1 [The `toJson` API](#31-the-tojson-api)
        * 3.1.1 [API Parameters](#311-api-parameters)
            * 3.1.1.1 [The `copybookData` Parameter](#3111-the-copybookdata-parameter)
            * 3.1.1.2 [The `targetRecordName` Parameter](#3112-the-targetrecordname-parameter)
        * 3.1.2 [Return Type](#312-return-type)
4. [Convert JSON to Copybook ASCII](#4-convert-json-to-copybook-ascii)
    * 4.1 [The `toCopybook` API](#41-the-tocopybook-api)
        * 4.1.1 [API Parameters](#411-api-parameters)
            * 4.1.1.1 [The `input` Parameter](#4111-the-input-parameter)
            * 4.1.1.2 [The `targetRecordName` Parameter](#4112-the-targetrecordname-parameter)
        * 4.1.2 [Return Type](#412-return-type)
5. [Convert Copybook ASCII to Ballerina Record](#5-convert-copybook-ascii-to-ballerina-record)
    * 5.1 [The `fromCopybook` API](#51-the-fromcopybook-api)
        * 5.1.1 [API PArameters](#511-api-parameters)
            * 5.1.1.1 [The `copybo0kData` Parameter](#5111-the-copybookdata-parameter)
            * 5.1.1.2 [The `targetRecordName` Parameter](#5112-the-targetrecordname-parameter)
            * 5.1.1.3 [The `t(targetRecordType)` Parameter](#5113-the-ttargetrecordtype-parameter)
        * 5.1.2 [Return Type](#512-return-type)
6. [The `copybook:Error` Type](#6-the-copybookerror-type)
7. [Supported Copybook Types](#7-supported-copybook-types)

## 1. Overview
This specification elaborates on converting Copybook ASCII to JSON and vice versa, as well as converting Copybook ASCII to a specific Ballerina record.

The Copybook module provides three major functionalities that simplify the copybook value handling.
1. Convert Copybook ASCII to JSON
2. Convert JSON to Copybook ASCII
3. Convert Copybook ASCII to Ballerina Record

The module presently supports a limited set of copybook types. Future updates will expand this support to include other possible picture types to enhance the module's usability.

## 2. Initialize the Copybook Converter
The copybook converter needs to be initialized before performing the functionalities.

### 2.1 The `init` Method
The `init` method can be used to initialize the copybook converter. This method has a parameter named `schemaFilePath` which accepts the path of the copybook definition file. The method will return an error in case of failure.


###### Example: Initializing the Converter
```ballerina
copybook:Converter converter = check new ("../resources/copybook.cpy");
```

## 3. Convert Copybook ASCII to JSON
The copybook module can be used to convert the Copybook ASCII to JSON.

### 3.1 The `toJson` API
The `toJson` is the API designed for copybook ASCII to JSON conversion.

#### 3.1.1 API Parameters

##### 3.1.1.1 The `copybookData` Parameter
The `copybookData` is the first parameter of `toJson` API that accepts the `string` type data. The copybook ASCII value that needs to be converted can be passed using the copybookData parameter.

##### 3.1.1.2 The `targetRecordName` Parameter
The `targetRecordName` parameter is the name of the copybook record definition in the copybook definition. If the provided schema file contains more than one copybook record type definition, the `string` type `targetRecordName` must be provided.

#### 3.1.2 Return Type
The function returns a `JSON` or `copybook:Error` value based on the conversion.

- When there are no conversion errors, It returns a JSON with `data` field.
    ```json
    {
        "data": "<converted-json-value>"
    }
    ```

- When there are conversion errors, It returns a JSON with `data` and `errors` fields.
    ```json
    {
        "data": "<partial-converted-json-value>",
        "errors": ["<conversion errors>"]
    }
    ```

- If an error occurs during the execution, the API returns a `copybook:Error`.

###### Example: Convert to JSON
```ballerina
json jsonValue = check converter.toJson("0001Maharoof 01500.00A+");
```

## 4. Convert JSON to Copybook ASCII
This section describes the details of JSON to copybook ASCII conversion.

### 4.1 The `toCopybook` API
The `toCopybook` API can be used to convert the given JSON or Record data into copybook ASCII data.

#### 4.1.1 API Parameters

##### 4.1.1.1 The `input` Parameter
The `input` parameter accepts a JSON or Ballerina record value that is needed to be converted to copybook ASCII.

##### 4.1.1.2 The `targetRecordName` Parameter
The `targetRecordName` parameter is the name of the copybook record definition in the copybook definition. If the provided definition file contains more than one copybook record type definition, `targetRecordName` must be provided as a `string` value. The default value is nil.

#### 4.1.2 Return Type
The function returns a converted ASCII string or a `copybook:Error` based on the conversion.

###### Example: Convert to Copybook ASCII
```ballerina
json jsonValue = check converter.toCopybook({"EmployeeName": {"Name": "Mahroof"}});
```

## 5. Convert Copybook ASCII to Ballerina Record
The copybook module provides an API to convert a given copybook ASCII to a Ballerina record type.

### 5.1 The `fromCopybook` API
The `fromCopybook` API facilitates the conversion of copybook ASCII into a given Ballerina record type.

#### 5.1.1 API Parameters

##### 5.1.1.1 The `copybookData` Parameter
The `copybookData` parameter is an ASCII string that needs to be converted to a Ballerina record value.

##### 5.1.1.2 The `targetRecordName` Parameter
The `targetRecordName` parameter is the name of the copybook record definition in the copybook definition. If the provided copybook definition file contains more than one copybook record type definition, `targetRecordName` must be provided as a string. The default value is nil.

##### 5.1.1.3 The `t(targetRecordType)` Parameter
The `t(targetRecordType)` parameter accepts the type descriptor of the target record type.

#### 5.1.2 Return Type
The function returns a `record` value on success, or a `copybook:Error` in case of conversion errors.

###### Example: Convert to Ballerina Record
```ballerina
Employee employee = check converter.fromCopybook("0001Maharoof 01500.00A+");
```

## 6. The `copybook:Error` Type
The `copybook:Error` type represents all the errors related to the Copybook module. This is a subtype of the Ballerina `error` type.

## 7. Supported Copybook Types
- **PIC  X__**
- **PIC  X(__)**
- **PIC  9__**
- **PIC  S9(_)**
- **PIC  9(_)**
- **PIC  -9(_).__**
- **PIC  Z(_)9.__**
