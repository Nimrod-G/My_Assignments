package sortUtils;

/**
 * Created by Nimrod Golan on 01/08/2016.
 */
public class MergeSort {

    public static int[] mergeSort(int[] list) {
        // Stop condition
        if (list.length <= 1) {
            return list;
        } else {
            // Splitting the list into a half
            int[] first = new int[list.length/2];
            int[] second = new int[list.length - first.length];

            // Fill both sub-arrays
            System.arraycopy(list, 0, first, 0, first.length);
            System.arraycopy(list, first.length, second, 0, second.length);

            // Divide sub-arrays until each has 1 element
            mergeSort(first);
            mergeSort(second);

            sortAndMerge(first, second, list);

            return list;
        }
    }

    private static void sortAndMerge(int[] first, int[] second, int[] listToSort) {
        int firstIndex = 0;
        int secondIndex = 0;
        int listIndex = 0;

        while (firstIndex < first.length && secondIndex < second.length) {
            if (first[firstIndex] < second[secondIndex]) {
                listToSort[listIndex] = first[firstIndex];
                firstIndex++;
            } else {
                listToSort[listIndex] = second[secondIndex];
                secondIndex++;
            }
            listIndex++;
        }

        // Copy the last 'big' element which left to the end of the list
        System.arraycopy(first, firstIndex, listToSort, listIndex, first.length-firstIndex);
        System.arraycopy(second, secondIndex, listToSort, listIndex, second.length-secondIndex);
    }

    public static void main(String[] args) {
        int[] myList = new int[]{3, 1, 8, 12, 5, 9, 34, 2, 14};
        int[] ints = MergeSort.mergeSort(myList);
        int q = 0;
    }
}
