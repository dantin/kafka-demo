package com.cosmos.kafka.client;

import com.cosmos.kafka.client.producer.SimpleProducer;

/**
 * Bootstrap class
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        String topic = args[0];
        System.out.printf("Using topic: %s\n", topic);
        Thread producer = new Thread(new SimpleProducer(topic));
        producer.join();
    }
}
