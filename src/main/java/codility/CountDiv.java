package codility;

/**
 * Created by Nimrod Golan on 25/08/2016.
 */
public class CountDiv {
    public int solution(int A, int B, int K) {

        if (K == 1) {
            return (B - A) + 1;
        }

        if (A == B) {
            if (A % K == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int diff = B - A;
        int result = diff / K;
        return result+1;
    }

    public static void main(String[] args) {
        CountDiv divide = new CountDiv();
        int solution = divide.solution(1, 100, 100);
        int q = 0;
    }
}
