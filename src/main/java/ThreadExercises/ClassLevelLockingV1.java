package ThreadExercises;

/**
 * Created by Nimrod Golan on 03/08/2016.
 */

public class ClassLevelLockingV1 {

    public void printMe(String name) {
        synchronized (ClassLevelLockingV1.class) {
            System.out.println("Thread name: " + name + " got lock with ClassLevelLockingV1 instance");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println("Thread name: " + name + " releasing lock with ClassLevelLockingV1 instance");
        }
    }

    public void printMe2(String name) {
        synchronized (ClassLevelLockingV1.class) {
            System.out.println(name + " is in print2()");
        }
    }

    public void print2(String name) {
        System.out.println("Thread name: " + name + " is in print2");
    }
}
