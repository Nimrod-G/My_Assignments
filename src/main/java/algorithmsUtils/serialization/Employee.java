package algorithmsUtils.serialization;

import java.io.Serializable;

/**
 * Created by Nimrod Golan on 16/09/2016.
 */
public class Employee implements Serializable{
    public String name;
    public String address;
    public transient int SSN;
    public int number;
    public transient String lastName;

    public void mailCheck() {
        System.out.println("Mailing a check to " + name + " " + address);
    }
}
