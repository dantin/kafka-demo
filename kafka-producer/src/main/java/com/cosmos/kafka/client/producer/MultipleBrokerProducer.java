package com.cosmos.kafka.client.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;

/**
 * Producer using multiple partition
 */
public class MultipleBrokerProducer implements Runnable {

    private KafkaProducer<Integer, String> producer;
    private String topic;

    public MultipleBrokerProducer(String topic) {
        final Properties props = new Properties();
        props.put("metadata.broker.list", "localhost:9092,localhost:9093,localhost:9094");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("partitioner.class", "org.apache.kafka.clients.producer.internals.DefaultPartitioner");
        props.put("request.required.acks", "1");

        this.producer = new KafkaProducer<>(props);
        this.topic = topic;
    }

    @Override
    public void run() {
        System.out.println("Sending 1000 messages");
        Random rnd = new Random();
        int i = 1;
        while (i <= 1000) {
            int key = rnd.nextInt(255);
            String message = String.format("Message for key - [%d]: %d", key,  i);
            System.out.printf("Send: %s\n", message);
            this.producer.send(new ProducerRecord<>(this.topic, key, message));
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
