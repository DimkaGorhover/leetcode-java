package org.gd.leetcode.p0011;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.TWO_POINTERS
        })
class Solution {

    private static int max(int i1, int i2, int i3) { return Math.max(i1, Math.max(i2, i3)); }

    public int maxArea(int[] height) {
        switch (height.length) {
            case 0:
            case 1: return 0;
            case 2: return Math.min(height[0], height[1]);
            case 3: return max(height[0], height[1], height[2]);
        }
        int i = 0, j = height.length - 1, max = Integer.MIN_VALUE, h;
        while (i < j) {
            max = Math.max(max, (j - i) * (h = Math.min(height[i], height[j])));
            while (height[i] <= h && i < j) i++;
            while (height[j] <= h && i < j) j--;
        }
        return max;
    }
}
