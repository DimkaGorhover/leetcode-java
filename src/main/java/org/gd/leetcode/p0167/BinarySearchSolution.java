package org.gd.leetcode.p0167;

import java.util.Arrays;

/**
 * @author Horkhover Dmytro
 * @see OMGSolution
 * @see TwoPointersSolution
 * @since 2020-08-07
 * @deprecated Binary search is not optimal solution. Use {@link TwoPointersSolution Two Pointers Solution} instead
 */
@Deprecated
class BinarySearchSolution implements Solution {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            final int number = numbers[i];
            if (numbers[i + 1] > target - number)
                break;

            final int pos = Arrays.binarySearch(numbers, i + 1, numbers.length, target - number);
            if (pos > 0) {
                return new int[]{i + 1, pos + 1};
            }
        }

        throw new RuntimeException("test case is not valid");
    }
}
