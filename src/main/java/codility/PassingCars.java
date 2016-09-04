package codility;

/**
 * Created by Nimrod Golan on 31/08/2016.
 */
public class PassingCars {

    public int solution(int[] A) {
//        int counter = 0;
//
//        if (A.length == 1) {
//            return 0;
//        } else {
//            for (int i=0; i < A.length; i++) {
//                if (A[i] == 1) {
//                    continue;
//                } else {
//                    int currentElementIndex = i;
//                    while (currentElementIndex != A.length-1) {
//                        currentElementIndex++;
//                        if (A[currentElementIndex] == 1) {
//                            counter++;
//                        }
//                    }
//                }
//            }
//            if (counter > 1000000000) {
//                return -1;
//            } else {
//                return counter;
//            }
//        }
        int countOfZeros = 0, count = 0;

        for (int i = 0; i < A.length; i++){
            if (A[i] == 0) countOfZeros++;
            if (A[i] == 1) count += countOfZeros;
            if (count > 1000000000) return -1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = new int[] {0, 1,0, 1, 1};
        PassingCars passingCars = new PassingCars();
        int solution = passingCars.solution(array);
        int q = 0;
    }
}
