#!/bin/sh

OUT=.

openapi-generator generate \
    -i ./pokemon.yml \
    -o ${OUT}/ \
    --api-package com.enomoso.openapidemo.generated.server.controller \
    --model-package com.enomoso.openapidemo.generated.server.model \
    -g spring \
    --library spring-boot \
    -p interfaceOnly=true \
    -p dateLibrary=java8