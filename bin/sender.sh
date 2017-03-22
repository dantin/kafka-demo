#!/usr/bin/env bash

cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`

unzip ${DEPLOY_DIR}/kafka-producer/target/kafka-producer-1.0-SNAPSHOT-bin.zip -d ${DEPLOY_DIR}/kafka-producer/target

LIB_DIR=${DEPLOY_DIR}/kafka-producer/target/lib
LIB_JARS=`ls ${LIB_DIR} | grep .jar | awk '{print "'${LIB_DIR}'/"$0}' | tr "\n" ":"`

java -classpath ${LIB_JARS} com.cosmos.kafka.client.producer.SimpleProducer kafkatopic Hello_There
