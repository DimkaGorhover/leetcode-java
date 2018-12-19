package org.gd.leetcode.p0136;

/**
 * https://leetcode.com/problems/single-number/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-19
 */
class Solution {

    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) nums[0] ^= nums[i];
        return nums[0];
    }
}
