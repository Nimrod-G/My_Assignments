package codility;

/**
 * Created by Nimrod Golan on 12/09/2016.
 */
public class FrogJump {

    public int solution(int X, int[] A) {
        boolean[] isFoundArray = new boolean[X + 1];
        int steps = X;

        for (int i = 0; i < A.length; i++) {
            if (!isFoundArray[A[i]]) {
                isFoundArray[A[i]] = true;
                steps--;
            }
            if (steps == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] array = new int[] {1, 3, 1, 4, 2, 3, 5, 4};
        FrogJump frog = new FrogJump();
        int solution = frog.solution(5, array);
        int q = 0;
    }

}
