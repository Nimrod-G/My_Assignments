package codility;

import java.util.Arrays;

/**
 * Created by Nimrod Golan on 24/08/2016.
 */
public class OddOccurrencesInArray {

    public int solution(int[] A) {
        if (A.length % 2 == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        } else {
            Arrays.sort(A);
            long count = 1;

            for (int i=0; i < A.length; i++) {
                if (i == A.length-1) {
                    return A[i];
                }

                if (A[i] == A[i+1]) {
                    count++;
                } else {
                    if (count >=2) {
                        count = 1;
                    } else {
                        return A[i];
                    }
                }
            }
        }
        return 0;
    }
}
