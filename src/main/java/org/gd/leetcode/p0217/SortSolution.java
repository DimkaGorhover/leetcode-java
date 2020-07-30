package org.gd.leetcode.p0217;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-28
 */
class SortSolution implements Solution {

    public boolean containsDuplicate(int[] nums) {

        java.util.Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] == nums[i + 1])
                return true;

        return false;
    }
}
