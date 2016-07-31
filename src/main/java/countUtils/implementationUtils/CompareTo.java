package countUtils.implementationUtils;

/**
 * Created by Nimrod Golan on 12/07/2016.
 */
public class CompareTo {

    /**
     * Compare lexicographically 2 string
     * @param a
     * @param b
     * @return
     */
    public int myLexicographicallyCompare(String a, String b) {

        for (int i=0; i < a.length() && i < b.length(); i++) {
            int diff = a.charAt(i) - b.charAt(i);
            if (diff != 0) {
                return diff;
            }
        }
        return a.length() - b.length();
    }
}
