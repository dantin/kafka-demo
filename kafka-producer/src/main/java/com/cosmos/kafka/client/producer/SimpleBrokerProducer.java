package com.cosmos.kafka.client.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Producer using single partition
 */
public class SimpleBrokerProducer implements Runnable {
    private KafkaProducer<Integer, String> producer;
    private String topic;

    public SimpleBrokerProducer(String topic) {
        final Properties props = new Properties();
        props.put("metadata.broker.list", "localhost:9092");
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // by default, producer works in "fire and forget" mode
        props.put("request.required.acks", "1");

        this.producer = new KafkaProducer<>(props);
        this.topic = topic;
    }

    @Override
    public void run() {
        System.out.println("Sending 1000 messages");
        int i = 1;
        while (i <= 1000) {
            String message = String.format("Message[%d]", i);
            System.out.printf("Send: %s\n", message);
            this.producer.send(new ProducerRecord<>(this.topic, message));
            i++;
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        producer.close();
    }
}
