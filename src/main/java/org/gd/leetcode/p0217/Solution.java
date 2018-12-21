package org.gd.leetcode.p0217;

/**
 * https://leetcode.com/problems/contains-duplicate/
 *
 * @author Gorkhover D.
 * @since 2018-11-01
 */
class Solution {

    public boolean containsDuplicate(int[] nums) {
        java.util.Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] == nums[i + 1])
                return true;
        return false;
    }
}
