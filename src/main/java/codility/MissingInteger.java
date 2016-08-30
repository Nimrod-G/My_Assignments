package codility;

import java.util.HashSet;

/**
 * Created by Nimrod Golan on 24/08/2016.
 */
public class MissingInteger {

    public int solution(int[] A) {
        int num = 1;
        HashSet<Integer> hset = new HashSet<>();

        for (int i = 0 ; i < A.length; i++) {
            hset.add(A[i]);

            while (hset.contains(num)) {
                num++;
            }
        }

        return num;

       }

    public static void main(String[] args) {
        MissingInteger missingInteger = new MissingInteger();
        int[] array = new int[]{-5,-4,-3,-2,0};
        int solution = missingInteger.solution(array);
        int q = 0;
    }

}
