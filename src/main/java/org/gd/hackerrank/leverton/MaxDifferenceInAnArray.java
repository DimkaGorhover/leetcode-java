package org.gd.hackerrank.leverton;

/**
 * @author Horkhover Dmytro
 * @since 2019-03-06
 */
class MaxDifferenceInAnArray {

    static int maxDiff(int[] arr) {
        if (arr == null || arr.length <= 1)
            return 0;

        int min = arr[0];
        int max = arr[0];
        int diff = 0;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            diff = Math.max(diff, max - min);
        }

        return diff;
    }
}
