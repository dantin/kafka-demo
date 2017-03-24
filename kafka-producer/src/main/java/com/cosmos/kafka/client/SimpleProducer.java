package com.cosmos.kafka.client;

import com.cosmos.kafka.client.producer.SimpleBrokerProducer;

/**
 * Bootstrap class
 */
public class SimpleProducer {
    public static void main(String[] args) throws InterruptedException {
        String topic = args[0];
        System.out.printf("Using topic: %s\n", topic);
        Thread producer = new Thread(new SimpleBrokerProducer(topic));
        producer.start();
        producer.join();
    }
}
