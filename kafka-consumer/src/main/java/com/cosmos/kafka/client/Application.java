package com.cosmos.kafka.client;

import com.cosmos.kafka.client.consumer.SimpleHLConsumer;

/**
 * Bootstrap class
 */
public class Application {
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 2) {
            System.out.println("java -jar xxx.jar <mode> <topic>");
            System.out.println();
            System.out.println("mode: simple/multiple");
            System.out.println("topic: kafka topic name");
            System.out.println();
            return;
        }

        String mode = args[0];
        String topic = args[1];
        System.out.printf("mode %s, listening topic: %s\n", mode, topic);

        Thread consumer;

        switch (mode) {
            case "simple":
                consumer = new Thread(new SimpleHLConsumer(topic));
                break;
            default:
                System.err.println("Invalid mode value!");
                return;
        }
        consumer.start();
        consumer.join();
    }
}
