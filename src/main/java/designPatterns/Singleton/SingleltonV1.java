package designPatterns.singleton;

/**
 * Created by Nimrod Golan on 02/08/2016.
 */

public class SingleltonV1 {
    // Not a thread safe
    private static SingleltonV1 instance = null;

    private SingleltonV1() {}

    public static SingleltonV1 getInstance() {
        if (instance == null) {
            instance = new SingleltonV1();
        }
        return instance;
    }
}
