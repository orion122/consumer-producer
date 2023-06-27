package org.example;

import java.util.concurrent.ArrayBlockingQueue;

public class Main {

    public static final int QUEUE_CAPACITY = 10;
    public static final int PRODUCER_DELAY_MS = 200;
    public static final int CONSUMER_DELAY_MS = 500;

    public static void main(String[] args) {
        System.out.println("Start!");

        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

        Producer producer = new Producer(queue, PRODUCER_DELAY_MS, QUEUE_CAPACITY);
        Consumer consumer = new Consumer(queue, CONSUMER_DELAY_MS, QUEUE_CAPACITY);

        Thread threadProducer = new Thread(producer);
        Thread threadConsumer = new Thread(consumer);

        threadProducer.start();
        threadConsumer.start();

        try {
            threadProducer.join();
            threadConsumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finish!");
    }
}
