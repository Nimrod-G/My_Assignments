package ThreadExercises;

/**
 * Created by Nimrod Golan on 11/08/2016.
 */
public class ObjectLevelLockV2 {

    public synchronized void first(String threadName) {
        System.out.println(threadName + " is in first!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    public synchronized void second(String threadName) {
        System.out.println(threadName + " is in second!");
    }

    public synchronized  void firstAndSecond(String threadName) {
        first(threadName);
        second(threadName);
    }
}
