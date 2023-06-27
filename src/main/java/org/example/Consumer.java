package org.example;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final Integer delay;
    private final Integer maxElCount;
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue, Integer delay, Integer maxElCount) {
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
                bq.take();
                System.out.println("After consumed: " + bq);
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
