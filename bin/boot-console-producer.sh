#!/usr/bin/env bash

cd /opt/kafka/kafka_2.12-0.10.2.0
bin/kafka-console-producer.sh --broker-li localhost:9092 --topic kafkatopic
