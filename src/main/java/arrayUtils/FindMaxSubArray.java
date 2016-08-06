package arrayUtils;

import exceptionsInfra.SystemException;

/**
 * Created by Nimrod Golan on 03/08/2016.
 */
public class FindMaxSubArray {

    public static int findMaxSubArr(int[] array) throws SystemException {
        if (array.length == 0 || array == null) {
            throw new SystemException("Array not initialized");
        } else if (array.length == 1) {
            return array[0];
        } else {
            int max = array[0];
            int[] sum = new int[array.length];

            for (int i = 1; i < array.length; i++) {
                sum[i] = Math.max(array[i], sum[i-1] + array[i]);
                max = Math.max(sum[i], max);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int[] myArr = new int[]{-2, 5, 1, -3, 2, 10};
        int max = FindMaxSubArray.findMaxSubArr(myArr);

        System.out.println("Max is: " + max);
    }
}
