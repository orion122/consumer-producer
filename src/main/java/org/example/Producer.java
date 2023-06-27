package org.example;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final Integer delay;
    private final Integer maxElCount;
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue, Integer delay, Integer maxElCount) {
        this.queue = queue;
        this.delay = delay;
        this.maxElCount = maxElCount;
    }

    public BlockingQueue<Integer> getQueue() {
        return queue;
    }

    public Integer getMaxElement() {
        return maxElCount;
    }

    @Override
    public void run() {
        BlockingQueue<Integer> bq = getQueue();

        for (int i = 0; i < getMaxElement(); i++) {
            try {
                bq.put(i);
                System.out.println("After produced: " + bq);
                Thread.sleep(getDelay());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Integer getDelay() {
        return delay;
    }
}
