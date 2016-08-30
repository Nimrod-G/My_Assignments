package codility;

/**
 * Created by Nimrod Golan on 24/08/2016.
 */
public class BinaryGap {
    public int solution(int N) {

        int currentLength = 0;
        int currentMax = 0;

        while (N % 2 == 0) {
            N = N/2;
        }

        while (N != 0) {
            if (N % 2 == 0) {
                currentLength++;
            } else {
                if (currentLength != 0) {
                    if (currentLength > currentMax) {
                        currentMax = currentLength;
                    }
                    currentLength = 0;
                }
            }
            N = N/2;
        }
        return currentMax;
    }
}
