package designPatterns.singleton;

/**
 * Created by Nimrod Golan on 02/08/2016.
 */

public class SingleltonV2 {
    // Thread safe
    private static SingleltonV2 instance = null;

    private SingleltonV2() {}

    public static synchronized SingleltonV2 getInstance() {
        if (instance == null) {
            instance =  new SingleltonV2();
        }
        return instance;
    }
}
