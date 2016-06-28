package sortUtils;

public class SortUtils {

    public static int[] findMissingNumbersAndSortArray(int[] unSortArray) {
        int[] countArray = new int[unSortArray.length];

        for (int i=0; i < unSortArray.length; i++) {
            countArray[unSortArray[i]-1]++;
        }

        for (int i=0; i < countArray.length; i++) {
            if (countArray[i] == 0) {
                System.out.println("The number: " + (i + 1) + " is missing");
            }
        }

        int[] sortedArray = new int[unSortArray.length];
        int sortedArrayIndex = 0;

        for (int i=0; i < countArray.length; i++) {
            if (countArray[i] != 0) {
                for (int j=0; j < countArray[i]; j++, sortedArrayIndex++) {
                    sortedArray[sortedArrayIndex] = (i+1);
                }
            }
        }
        return sortedArray;
    }
}
