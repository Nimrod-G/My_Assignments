package ThreadExercises;

import java.util.Objects;

/**
 * Created by Nimrod Golan on 31/07/2016.
 */
public class DeadLockExe1 {

    public static Object objectA = new Object();
    public static Object objectB = new Object();

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();
    }

    private static class Thread1 extends Thread {

        @Override
        public void run() {
            synchronized (objectA) {
                System.out.println("Thread1 is holding objectA lock");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }

                System.out.println("Thread1 is waiting for objectB lock");
                synchronized (objectB) {
                    System.out.println("Thread1 is holding objectB lock");
                }
            }
        }
    }

    private static class Thread2 extends Thread {

        @Override
        public void run() {
            synchronized (objectB) {
                System.out.println("Thread2 is holding objectB lock");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread2 is waiting for objectA lock");
                synchronized (objectA) {
                    System.out.println("Thread2 is holding objectA lock");
                }
            }
        }
    }
}
