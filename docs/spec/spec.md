# Specification: Ballerina Copybook Library

_Owners_: @MohamedSabthar @DimuthuMadushan \
_Reviewers_: @ThisaruGuruge \
_Created_: 2023/11/16 \
_Updated_: 2023/11/16 \
_Edition_: Swan Lake

## Introduction

The Ballerina Copybook module is designed to effortlessly manage the conversion of Copybook data structures to JSON and the reverse.

The Copybook library specification has evolved and may continue to evolve in the future. The released versions of the specification can be found under the relevant GitHub tag.

If you have any feedback or suggestions about the library, start a discussion via a [GitHub issue](https://github.com/ballerina-platform/ballerina-library/issues) or in the [Discord server](https://discord.gg/ballerinalang). Based on the outcome of the discussion, the specification and implementation can be updated. Community feedback is always welcome. Any accepted proposal, which affects the specification is stored under `/docs/proposals`. Proposals under discussion can be found with the label `type/proposal` in GitHub.

The conforming implementation of the specification is released and included in the distribution. Any deviation from the specification is considered a bug.

## Contents

1. [Overview](#1-overview)
2. [Initialize the Copybook Converter](#2-initialize-the-copybook-converter)
    * 2.1 [The `init` Method](#21-the-init-method)
3. [Convert Copybook Payload to JSON](#3-convert-copybook-payload-to-json)
    * 3.1 [The `fromBytes` API](#31-the-frombytes-api)
        * 3.1.1 [API Parameters](#311-api-parameters)
            * 3.1.1.1 [The `bytes` Parameter](#3111-the-bytes-parameter))
            * 3.1.1.2 [The `targetRecordName` Parameter](#3112-the-targetrecordname-parameter)
            * 3.1.1.3 [The `encoding` Parameter](#3113-the-encoding-parameter)
        * 3.1.2 [Return Type](#312-return-type)
4. [Convert JSON to Copybook Payload](#4-convert-json-to-copybook-payload)
    * 4.1 [The `toBytes` API](#41-the-tobytes-api)
        * 4.1.1 [API Parameters](#411-api-parameters)
            * 4.1.1.1 [The `input` Parameter](#4111-the-input-parameter)
            * 4.1.1.2 [The `targetRecordName` Parameter](#4112-the-targetrecordname-parameter)
            * 4.1.1.3 [The `encoding` Parameter](#4113-the-encoding-parameter)
        * 4.1.2 [Return Type](#412-return-type)
5. [The `copybook:Error` Type](#5-the-copybookerror-type)
6. [Supported Copybook Types](#6-supported-copybook-types)

## 1. Overview

This specification elaborates on converting Copybook payload to JSON and vice versa.

The Copybook module provides two major functionalities that simplify the copybook value handling.

1. Convert Copybook payload to JSON
2. Convert JSON to Copybook payload

The module presently supports a limited set of copybook types. Future updates will expand this support to include other possible picture types to enhance the module's usability.

## 2. Initialize the Copybook Converter

The copybook converter needs to be initialized before performing the functionalities.

### 2.1 The `init` Method

The `init` method can be used to initialize the copybook converter. This method has a parameter named `schemaFilePath` which accepts the path of the copybook definition file. The method will return an error in case of failure.

###### Example: Initializing the Converter

```ballerina
copybook:Converter converter = check new ("../resources/copybook.cpy");
```

## 3. Convert Copybook Payload to JSON

The Copybook module can be used to convert a Copybook payload to JSON.

### 3.1 The `fromBytes` API

The `fromBytes` API is designed for converting Copybook payloads to JSON.

#### 3.1.1 API Parameters

##### 3.1.1.1 The `bytes` Parameter

The `bytes` parameter is the first parameter of the `fromBytes` API. It accepts data of the `byte[]` type. The Copybook payload that needs to be converted should be passed using this parameter.

##### 3.1.1.2 The `targetRecordName` Parameter

The `targetRecordName` parameter specifies the name of the Copybook record definition in the Copybook schema. If the provided schema file contains more than one Copybook root record type definition, the `targetRecordName` can be provided to convert the given [`byte[]`](#3111-the-bytes-parameter) payload against a specific root record. Otherwise, the [`byte[]`](#3111-the-bytes-parameter) payload will be parsed against all records in the Copybook sequentially.

##### 3.1.1.3 The `encoding` Parameter

The `encoding` parameter is the final parameter of the `fromBytes` API. It accepts either `copybook:ASCII` or `copybook:EBCDIC` as its value, specifying the encoding of the [`byte[]`](#3111-the-bytes-parameter) payload. If no value is provided for the encoding parameter, the [`byte[]`](#3111-the-bytes-parameter) payload will be considered as `copybook:ASCII` encoded by default.

#### 3.1.2 Return Type

The function returns a `map<json>` or `copybook:Error` value based on the conversion.

* When there are no conversion errors, It returns a JSON with `data` field.

    ```json
    {
        "data": "<converted-json-value>"
    }
    ```

* When there are conversion errors, It returns a JSON with `data` and `errors` fields.

    ```json
    {
        "data": "<partial-converted-json-value>",
        "errors": ["<conversion errors>"]
    }
    ```

* If an error occurs during the execution, the API returns a `copybook:Error`.

###### Example: Convert to JSON

```ballerina
map<json> jsonValue = check converter.fromBytes("0001Maharoof 01500.00A+".toBytes());
```

## 4. Convert JSON to Copybook Payload

This section describes the details of JSON to copybook payload conversion.

### 4.1 The `toBytes` API

The `toBytes` API is used to convert the given JSON or Record data into a Copybook payload.

#### 4.1.1 API Parameters

##### 4.1.1.1 The `input` Parameter

The `input` parameter accepts either a `map<json>` or a Ballerina record value that needs to be converted into a Copybook payload.

##### 4.1.1.2 The `targetRecordName` Parameter

The `targetRecordName` parameter specifies the name of the Copybook record definition in the Copybook schema. If the provided schema file contains more than one Copybook root record type definition, the `targetRecordName` can be provided to convert the given [`input`](#4111-the-input-parameter) against a specific root record. Otherwise, the [`input`](#4111-the-input-parameter) payload will be considerd as an input to all the copybook root records.

##### 4.1.1.3 The `encoding` Parameter

The `encoding` parameter is the final parameter of the `toBytes` API. It accepts either `copybook:ASCII` or `copybook:EBCDIC` as its value, specifying the encoding of the [`byte[]`](#412-return-type) returned from the [`toBytes`](#41-the-tobytes-api) method. If no value is provided for the encoding parameter, the returned [`byte[]`](#412-return-type) payload will be considered as `copybook:ASCII` encoded by default.

#### 4.1.2 Return Type

The function returns a `byte[]` that is either `copybook:ASCII` or `copybook:EBCDIC` encoded, based on the conversion. On failure, a `copybook:Error` is returned.

###### Example: Convert to Copybook Payload

```ballerina
byte[] ebcdic = check converter.fromBytes({"EmployeeName": {"Name": "Mahroof"}}, encoding = copybook:EBCDIC);
```

## 5. The `copybook:Error` Type

The `copybook:Error` type represents all the errors related to the Copybook module. This is a subtype of the Ballerina `error` type.

## 6. Supported Copybook Types

| Copybook Type | Example |
|----------|----------|
| PIC  X__  | PIC X99, PIC X12 |
| PIC  X(__) | PIC X(03), PIC X(20) |
| PIC  9__ | PIC 999, PIC 999999 |
| PIC  S9(_) | PIC S9(05), PIC S9(12) |
| PIC  9(_) | PIC 9(07), PIC 9(14) |
| PIC  -9(_).__ | PIC -9(9).99, PIC -9(2).999 |
| PIC  Z(_)9.__ | PIC Z(9)9.99, PIC Z(2)9.999 |
| PIC  9(_)V__  | PIC 9(2)V99, PIC 9(13)V999  |
| PIC  S9(_)V__ | PIC S9(2)V99, PIC S9(13)V999|
