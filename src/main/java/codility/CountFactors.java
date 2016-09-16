package codility;

/**
 * Created by Nimrod Golan on 15/09/2016.
 */
public class CountFactors {
    public int solution(int N) {
       if (N == 1) {
           return 1;
       } else {
           int counter = 0;
           for (int i=1; i <= N; i++) {
               if (N % i == 0) {
                   counter++;
               }
           }
           return counter;
       }
    }

    public static void main(String[] args) {
        CountFactors count = new CountFactors();
        int solution = count.solution(24);
        int q = 0;
    }
}
