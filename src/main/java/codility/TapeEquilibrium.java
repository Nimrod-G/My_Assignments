package codility;

/**
 * Created by Nimrod Golan on 03/09/2016.
 */
public class TapeEquilibrium {

    public int solution(int[] A) {
       if (A.length == 2) {
           return Math.abs(A[0] - A[1]);
       } else {
           int sumOfLeft = 0;
           int sumOfRight = 0;
           int minDifference;
           int currentDifference;

           for (int i=1; i < A.length; i++) {
               sumOfRight += A[i];
           }

           sumOfLeft = A[0];
           minDifference = Math.abs(sumOfLeft - sumOfRight);
           
           for (int i=1; i < A.length-1; i++) {
               sumOfLeft += A[i];
               sumOfRight -= A[i];
               currentDifference = Math.abs((sumOfLeft) - (sumOfRight));
               if (currentDifference < minDifference) {
                   minDifference = currentDifference;
               }
           }
           return minDifference;
       }
    }

    public static void main(String[] args) {
        TapeEquilibrium tape = new TapeEquilibrium();
        int[] array = new int[] {3,1,2,4,3};
        int solution = tape.solution(array);
        int q = 0;
    }
}
