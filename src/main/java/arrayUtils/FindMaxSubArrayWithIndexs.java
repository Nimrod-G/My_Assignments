package arrayUtils;

import exceptionsInfra.SystemException;

/**
 * Created by Nimrod Golan on 03/08/2016.
 */
public class FindMaxSubArrayWithIndexs {

    public static int findMaxSubArrWithIndexs(int[] array) throws SystemException {
        if (array.length == 0 || array == null) {
            throw new SystemException("Array not initialized");
        } else if (array.length == 1) {
            return array[0];
        } else {
            int firstIndex = 0;
            int lastIndex = 0;
            int currentIndex=0;
            int max = array[0];
            int[] sum = new int[array.length];

            for (int i = 1; i < array.length; i++) {
                if (array[i] >=  sum[i-1] + array[i]) {
                    sum[i] = array[i];
                    if (sum[i-1] + array[i] > 0) {
                        firstIndex++;
                    }
                } else {
                    sum[i] = sum[i-1] + array[i];
                }
                currentIndex++;
                if (sum[i] > max) {
                    max = sum[i];
                    lastIndex = currentIndex;
                }
            }
            System.out.println("Max is: " + max + ", first index is: " + firstIndex + " and last index is: " + lastIndex);
            return max;
        }
    }

    public static void main(String[] args) {
        int[] myArr = new int[]{-2, 5, 1, -3, 2};
        int[] myArr2 = new int[]{-2, 5, 1, -3, 2, 10};
        int[] myArr3 = new int[]{-2,-3,-4,-5};
        int max = FindMaxSubArrayWithIndexs.findMaxSubArrWithIndexs(myArr2);

        System.out.println("Max is: " + max);
    }
}
