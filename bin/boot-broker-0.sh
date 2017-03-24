#!/usr/bin/env bash

KAFKA_ROOT=/opt/kafka/kafka_2.12-0.10.2.0

${KAFKA_ROOT}/bin/kafka-server-start.sh ${KAFKA_ROOT}/config/server.properties
