package codility;

/**
 * Created by Nimrod Golan on 25/08/2016.
 */
public class PermMissingElem {

    public int solution(int[] A) {
        if (A.length == 0) {
            return 1;
        } else if (A.length == 1) {
            return 1;
        } else {
            int[] countArray = new int[A.length+1];

            for (int element : A) {
                countArray[element-1]++;
            }

            for (int i=0; i < countArray.length; i++) {
                if (countArray[i] == 0) {
                    return i+1;
                }
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        PermMissingElem permMissingElem = new PermMissingElem();
        int[] array = new int[] {1,3,2,5};
        int solution = permMissingElem.solution(array);
        int q = 0;
    }
}
