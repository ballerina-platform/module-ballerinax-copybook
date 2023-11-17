# Copybook To Ballerina Conversion Example

[![Star on Github](https://img.shields.io/badge/-Star%20on%20Github-blue?style=social&logo=github)](https://github.com/ballerina-platform/module-ballerinax-copybook)

_Authors_: @MohamedSabthar @DimuthuMadushan \
_Reviewers_: @ThisaruGuruge \
_Created_: 2023/11/15 \
_Updated_: 2023/11/15

## Overview

This example illustrates the process of converting values between Copybook and JSON formats using Ballerina. Additionally, it offers convenient APIs for validating and accessing fields within the Copybook.

## Implementation

Implementation is purely done using the Ballerina. The implementation utilizes its Copybook package for seamless bidirectional conversion between Copybook and JSON data formats.

## Generate Ballerina Record Types
The Copybook CLI tool simplifies converting Copybook definitions into Ballerina code. When implementing the `getEmployeeSalary` and `validateJsonData` APIs, the CLI tool can be used to generate the record types. To generate the records, use the below command.

```shell
bal copybook -i <path-to-copybook-definition>
```

## Starting the Service

To start the service, move into the copybook folder and execute the below command.

```shell
bal run
```

It will build the Copybook Ballerina project and then run it.

## Sample Curl Command

```shell
curl -X POST 'http://localhost:9090/convertToJson' \
--header 'Content-Type: text/plain' \
--data-raw '0001Mahroof   Sabthar     01500.00A+99.820901R&D       29041Ballerina                               Vijya RoadKolonnawa  0100.00 09.2'
```
