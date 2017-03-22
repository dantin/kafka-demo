package com.cosmos.kafka.client.producer;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class SimpleProducer {
    private static KafkaProducer<Integer, String> producer;

    public SimpleProducer() {
        final Properties props = new Properties();
        props.put("metadata.broker.list", "localhost:9092");
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("request.required.acks", "1");

        producer = new KafkaProducer<>(props);
    }

    public static void main(String[] args) {
        SimpleProducer sp = new SimpleProducer();
        String topic = args[0];
        String message = args[1];
        System.out.printf("Send: %s\n", message);
        producer.send(new ProducerRecord<>(topic, message));
        producer.close();
    }
}
