package ThreadExercises.waitAndNotify;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nimrod Golan on 11/08/2016.
 */
public class TestWaitAndNotify {

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();

        Thread producerThread = new Thread(new Producer(myList, 5), "Producer Thread");
        Thread consumerThread = new Thread(new Consumer(myList), "Consumer Thread");

        producerThread.start();
        consumerThread.start();
    }
}
