package com.cosmos.kafka.client;

import com.cosmos.kafka.client.producer.MultipleBrokerProducer;

/**
 * Bootstrap class
 */
public class Multiple {
    public static void main(String[] args) throws InterruptedException {
        String topic = args[0];
        System.out.printf("Using topic: %s\n", topic);
        Thread producer = new Thread(new MultipleBrokerProducer(topic));
        producer.start();
        producer.join();
    }
}
