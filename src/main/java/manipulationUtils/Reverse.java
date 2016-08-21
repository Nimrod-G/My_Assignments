package manipulationUtils;

/**
 * Created by Nimrod Golan on 11/08/2016.
 */
public class Reverse {

    public static String reverseString(String myString) {
        StringBuilder sb = new StringBuilder();

        for (int i = myString.length()-1; i >= 0; i--) {
            sb.append(myString.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("nimrod"));
    }
}
