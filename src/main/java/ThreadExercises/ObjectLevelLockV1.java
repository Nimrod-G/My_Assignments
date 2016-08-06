package ThreadExercises;

/**
 * Created by Nimrod Golan on 03/08/2016.
 */
public class ObjectLevelLockV1 {

    public void printMe(String name) {
        synchronized (this) {
            System.out.println(name + " is inside printMe");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            System.out.println(name + " is going to release printMe");
        }
    }
}
