package algorithmsUtils;

import exceptionsInfra.SystemException;

/**
 * Created by Nimrod Golan on 04/08/2016.
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int keyToSearch) {
        int firstIndex = 0;
        int lastIndex = array.length-1;

        while (firstIndex <= lastIndex) {
            int middleIndex = firstIndex + (lastIndex-firstIndex)/2;

            if (keyToSearch == array[middleIndex]) {
                return middleIndex;
            }

            if (keyToSearch > array[middleIndex]) {
                firstIndex = middleIndex + 1;
            } else {
                lastIndex = middleIndex -1;
            }

        }
        throw new SystemException("The element: " + keyToSearch + " isn't exists");
    }
}
