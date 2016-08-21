package ThreadExercises.waitAndNotify;

import java.util.List;

/**
 * Created by Nimrod Golan on 11/08/2016.
 */
public class Consumer implements Runnable {

    private final List<Integer> taskQueue;

    public Consumer(List<Integer> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (taskQueue) {
            while (taskQueue.isEmpty()) {
                System.out.println("Task queue is empty! " + Thread.currentThread().getName() + " is waiting...");
                taskQueue.wait();
            }

            Thread.sleep(1000);
            Integer remove = taskQueue.remove(0);
            System.out.println("The element: " + remove + " has been removed");
            taskQueue.notifyAll();
        }
    }
}
