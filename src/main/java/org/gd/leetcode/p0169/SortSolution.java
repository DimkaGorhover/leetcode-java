package org.gd.leetcode.p0169;

import java.util.Arrays;

/**
 * @author Horkhover D.
 * @since 2020-07-13
 */
class SortSolution implements Solution {

    @Override
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }
}
