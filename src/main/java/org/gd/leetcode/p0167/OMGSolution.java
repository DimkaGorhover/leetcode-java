package org.gd.leetcode.p0167;

/**
 * @author Horkhover Dmytro
 * @see BinarySearchSolution
 * @see TwoPointersSolution
 * @since 2018-10-26
 * @deprecated Quad search ( O(n**2) ) is not optimal solution. Use {@link BinarySearchSolution Binary Search Solution}
 * instead
 */
@Deprecated
class OMGSolution implements Solution {

    public int[] twoSum(int[] numbers, int target) {

        int length = numbers.length;

        bigLoop:
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                final int sum = numbers[i] + numbers[j];
                if (sum == target) {
                    return new int[]{i + 1, j + 1};
                }
                if (sum > target) {
                    length = j;
                    continue bigLoop;
                }
            }
        }

        throw new RuntimeException("test case is not valid");
    }
}
