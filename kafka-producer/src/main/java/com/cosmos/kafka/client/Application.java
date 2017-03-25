package com.cosmos.kafka.client;

import com.cosmos.kafka.client.producer.MultipleBrokerProducer;
import com.cosmos.kafka.client.producer.SimpleBrokerProducer;

/**
 * Bootstrap class
 */
public class Application {
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 2) {
            System.out.printf("java -jar xxx.jar <mode> <topic>");
            System.out.println();
            System.out.println("mode: simple/multiple");
            System.out.println("topic: kafka topic name");
            System.out.println();
            return;
        }

        String mode = args[0];
        String topic = args[1];
        System.out.printf("Mode: %s, Topic: %s\n", mode, topic);

        Thread producer;
        switch (mode) {
            case "simple":
                producer = new Thread(new SimpleBrokerProducer(topic));
                break;
            case "multiple":
                producer = new Thread(new MultipleBrokerProducer(topic));
                break;
            default:
                System.err.println("invalid mode value!");
                return;
        }
        producer.start();
        producer.join();
    }
}
