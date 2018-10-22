package org.gd.leetcode.p0026;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        final int length = nums.length;
        switch (length) {
            case 0: return 0;
            case 1: return 1;
            case 2: return nums[0] == nums[1] ? 1 : 2;
        }

        int nl = 0;
        for (int i = 1; i < length; i++) {
            if (nums[nl] != nums[i]) nl++;
            nums[nl] = nums[i];
        }
        return nl + 1;
    }
}
