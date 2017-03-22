package com.cosmos.kafka.client;

import com.cosmos.kafka.client.consumer.SimpleHLConsumer;

/**
 * Bootstrap class
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        String topic = args[0];
        System.out.printf("listening topic: %s\n", topic);
        Thread consumer = new Thread(new SimpleHLConsumer(topic));
        consumer.start();
        consumer.join();
    }
}
