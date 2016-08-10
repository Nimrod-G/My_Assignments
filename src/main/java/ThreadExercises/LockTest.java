package ThreadExercises;

/**
 * Created by Nimrod Golan on 03/08/2016.
 */
public class LockTest {

    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1("Thread1");
        Thread2 t2 = new Thread2("Thread2");

        t1.start();
        Thread.sleep(500);
        t2.start();
    }

    public static class Thread1 extends Thread {

        private String name;

        public Thread1(String name) {
            super(name);
        }

        public void run() {
            ClassLevelLockingV1 classLevelLockingV1 = new ClassLevelLockingV1();
            classLevelLockingV1.printMe(getName());
        }
    }

    public static class Thread2 extends Thread {

        private String name;

        public Thread2(String name) {
            super(name);
        }

        public void run() {
            ClassLevelLockingV1 classLevelLockingV1 = new ClassLevelLockingV1();
            classLevelLockingV1.print2(getName());
            classLevelLockingV1.printMe(getName());
        }
    }
}
