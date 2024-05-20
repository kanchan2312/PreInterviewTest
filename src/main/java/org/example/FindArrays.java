package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/*
Task 2: Find the starting index where the second parameter occurs as a sub-array in the array given as the first parameter.
*/
public class FindArrays {

    private static Logger logger = Logger.getLogger(InvocationTime.class.getName());

    public static void main(String[] args) {

    }

    /**
     * Find index of sub array in main array - using collections API
     *
     * @param arr
     * @param subArr
     * @return index of sub array
     */
    public static int findSubArrayIndex(int [] arr, int [] subArr) {

        if (arr == null || subArr == null) {
            throw new NullPointerException("With null arrays, Index cannot be found");
        }

        /* If either of the arrays is empty or subarray is larger than main array then not found */
        if (arr.length == 0 || subArr.length == 0 || subArr.length > arr.length) {
            return -1;
        }

        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> subArrList = Arrays.stream(subArr).boxed().collect(Collectors.toList());

        logger.info("Index is: " + Collections.indexOfSubList(arrList, subArrList));
        int index = Collections.indexOfSubList(arrList, subArrList);

        return index;
    }

    /**
     * Finds index of sub array in main array - using Arrays method
     *
     * @param arr
     * @param subArr
     * @return index of sub array
     */
    private static int getSubArrayIndex (int [] arr, int [] subArr) {
        for (int i = 0; i < arr.length - subArr.length; i++) {
            if (containsAt(arr, subArr, i)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean containsAt(int [] arr, int [] subArr, int offset) {
        for (int i = 0; i < subArr.length; i++) {
            if (arr[i + offset] != subArr[i]) {
                return false;
            }
        }
        return true;
    }

}
