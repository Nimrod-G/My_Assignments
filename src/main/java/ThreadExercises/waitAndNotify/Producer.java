package ThreadExercises.waitAndNotify;

import java.util.List;

/**
 * Created by Nimrod Golan on 11/08/2016.
 */

public class Producer implements Runnable {

    private final List<Integer> taskQueue;
    private final int MAX_CAPACITY;

    public Producer(List<Integer> taskQueue, int MAX_CAPACITY) {
        this.taskQueue = taskQueue;
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    @Override
    public void run() {

        int counter = 0;
        while (true) {
            try {
                producer(counter++);
            } catch (InterruptedException e) {
            }
        }
    }

    private void producer(int counter) throws InterruptedException {
        synchronized (taskQueue) {
            while (taskQueue.size() == MAX_CAPACITY) {
                System.out.println("The queue is full! " + Thread.currentThread().getName() + " is now waiting...");
                taskQueue.wait();
            }

            Thread.sleep(1000);
            taskQueue.add(counter);
            System.out.println("New element producred: " + counter);
            taskQueue.notifyAll();
        }
    }
}
