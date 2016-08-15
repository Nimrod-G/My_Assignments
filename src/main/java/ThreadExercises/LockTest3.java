package ThreadExercises;

/**
 * Created by Nimrod Golan on 11/08/2016.
 */
public class LockTest3 {

    static ObjectLevelLockV2 simpleLockTest = new ObjectLevelLockV2();

    public static void main(String[] args) {
        Thread1 t1 = new Thread1("FirstThread");
        Thread t2 = new Thread2("SecondThread");

        t1.start();
        t2.start();

    }

    public static class Thread1 extends Thread {

        public Thread1(String name) {
            super(name);
        }

        @Override
        public void run() {
//            simpleLockTest.first(getName());
//            simpleLockTest.second(getName());
            simpleLockTest.firstAndSecond(getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public static class Thread2 extends Thread {

        public Thread2(String name) {
            super(name);
        }

        @Override
        public void run() {
//            simpleLockTest.second(getName());
//            simpleLockTest.first(getName());
            simpleLockTest.firstAndSecond(getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
