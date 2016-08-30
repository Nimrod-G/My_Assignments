package codility;

import java.util.Arrays;

/**
 * Created by Nimrod Golan on 24/08/2016.
 */
public class PermCheck {

    public int solution(int[] A) {

        if (A.length == 1) {
            if (A[0] == 1) {
                return 1;
            } else {
                return 0;
            }
        } else {
            Arrays.sort(A);
            int currentValue = 1;

            for (int i=0; i < A.length; i++, currentValue++) {
                if (A[i] == currentValue) {
                    continue;
                } else {
                    return 0;
                }
            }
            return 1;
        }
    }
}
