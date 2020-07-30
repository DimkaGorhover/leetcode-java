package org.gd.leetcode.p0217;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-28
 */
@Deprecated
class TwoPointersSolution implements Solution {

    public boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length <= 1)
            return false;

        int slow = 0;
        int fast = 1;
        while (slow < nums.length && nums[slow] != nums[fast]) {
            if (slow == fast)
                continue;
            slow += 1;
            fast += 2;
            if (fast >= nums.length)
                fast = 0;
        }

        return slow != fast;
    }
}
