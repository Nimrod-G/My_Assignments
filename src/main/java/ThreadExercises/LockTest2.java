package ThreadExercises;

/**
 * Created by Nimrod Golan on 03/08/2016.
 */
public class LockTest2 {

    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1("Thread1");
        Thread2 t2 = new Thread2("Thread2");

        t1.start();
        Thread.sleep(500);
        t2.start();
    }

    public static class Thread1 extends Thread {

        public Thread1(String name) {
            super(name);
        }

        public void run() {
            ObjectLevelLockV1 ob1 = new ObjectLevelLockV1();
            ob1.printMe(getName());
        }
    }

    public static class Thread2 extends Thread {

        public Thread2(String name) {
            super(name);
        }

        public void run() {
            ObjectLevelLockV1 ob1 = new ObjectLevelLockV1();
            ob1.printMe(getName());
        }
    }
}
