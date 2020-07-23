package org.gd.leetcode.p0074;

import java.util.Arrays;

/**
 * @author Horkhover Dmytro
 * @see DFSSolution
 * @see Arrays#binarySearch(int[], int)
 * @since 2020-07-23
 */
class BinarySearchSolution implements Solution {

    private static int binarySearchRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = matrix[mid][0];

            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid;
        }
        return low - 1;
    }


    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0)
            return false;

        int row = binarySearchRow(matrix, target);
        return row >= 0 && Arrays.binarySearch(matrix[row], target) > 0;
    }
}
