package designPatterns.singleton;

/**
 * Created by Nimrod Golan on 02/08/2016.
 */
public class SingleltonV3 {
    // Thread safe with double-checked locking

    private static SingleltonV3 instance = null;

    private SingleltonV3() {}

    public static SingleltonV3 getInstance() {
        if (instance == null) {
            synchronized (SingleltonV3.class) {
                // Double check
                if (instance == null) {
                    instance =  new SingleltonV3();
                }
            }
        }
        return instance;
    }
}
