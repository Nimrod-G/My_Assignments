package codility;

import java.util.Arrays;

/**
 * Created by Nimrod Golan on 14/09/2016.
 */
public class Triplet {
    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        } else {
            Arrays.sort(A);
            for (int i = 2; i < A.length; i++) {
                if ((long)A[i-2] + (long)A[i-1] > (long)A[i])
                    return 1;
            }
            return 0;

        }
    }

    public static void main(String[] args) {
        Triplet triplet = new Triplet();
        int[] array = new int[] {10, 2, 5, 1, 8, 20};
        int solution = triplet.solution(array);
        int q = 0;
    }
}
