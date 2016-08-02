package ThreadExercises;

/**
 * Created by Nimrod Golan on 01/08/2016.
 */
public class DeadLockExe2 {

    private static Object SushiPlate = new Object();
    private static Object SoySauce = new Object();

    public static void main(String[] args) {
        PersonA t1 = new PersonA();
        PersonB t2 = new PersonB();

        t1.start();
        t2.start();
    }

    private static class PersonA extends Thread {

        @Override
        public void run() {
            synchronized (SushiPlate) {
                System.out.println("PersonA is got the sushi plate");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }

                synchronized (SoySauce) {
                    System.out.println("PersonA is having the soy sauce");
                }
            }
        }
    }

    private static class PersonB extends Thread {

        @Override
        public void run() {
            synchronized (SoySauce) {
                System.out.println("PersonB is having the soy sauce");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }

                synchronized (SushiPlate) {
                    System.out.println("PersonB is got the sushi plate");
                }
            }
        }
    }
}
