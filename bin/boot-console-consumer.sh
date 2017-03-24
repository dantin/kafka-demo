#!/usr/bin/env bash

KAFKA_ROOT=/opt/kafka/kafka_2.12-0.10.2.0

${KAFKA_ROOT}/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic kafkatopic --from-beginning
