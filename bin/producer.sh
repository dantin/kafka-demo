#!/usr/bin/env bash

MODULE_NAME=kafka-producer

cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`

unzip ${DEPLOY_DIR}/${MODULE_NAME}/target/${MODULE_NAME}-1.0-SNAPSHOT-bin.zip -d ${DEPLOY_DIR}/${MODULE_NAME}/target

LIB_DIR=${DEPLOY_DIR}/${MODULE_NAME}/target/lib
LIB_JARS=`ls ${LIB_DIR} | grep .jar | awk '{print "'${LIB_DIR}'/"$0}' | tr "\n" ":"`

java -classpath ${LIB_JARS} com.cosmos.kafka.client.Simple kafkatopic
