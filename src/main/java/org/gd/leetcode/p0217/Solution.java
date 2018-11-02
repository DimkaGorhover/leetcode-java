package org.gd.leetcode.p0217;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/contains-duplicate/
 *
 * @author Gorkhover D.
 * @since 2018-11-01
 */
class Solution {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return false;
            set.add(nums[i]);
        }
        return true;
    }
}
