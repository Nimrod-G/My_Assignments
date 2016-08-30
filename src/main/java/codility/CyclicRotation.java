package codility;

/**
 * Created by Nimrod Golan on 24/08/2016.
 */
public class CyclicRotation {

    public int[] solution(int[] A, int K) {

        int arrayLength = A.length;
        int[] copyArray;

        if (A.length == 0) {
            return new int[0];
        } else if (A.length == 1) {
            return A;
        } else {
            copyArray = new int[arrayLength];

            for (int i=0; i < arrayLength; i++) {
                int updateIndex = (i + K) % arrayLength;
                copyArray[updateIndex] = A[i];
            }
        }
        return copyArray;
    }
}
