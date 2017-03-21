package com.cosmos.kafka.client.producer;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Created by david on 21/03/2017.
 */
public class SimpleProducer {
    private static KafkaProducer<Integer, String> producer;

    public SimpleProducer() {
        final Properties props = new Properties();
        props.put("broker.list", "localhost:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("request.required.acks", "1");

        producer = new KafkaProducer<Integer, String>(props);
    }

    public static void main(String[] args) {
        SimpleProducer sp = new SimpleProducer();
        String topic = args[0];
        String message = args[1];
        System.out.printf("Send: %s\n", message);
        producer.send(new ProducerRecord<Integer, String>(topic, message));
        producer.close();
    }
}
