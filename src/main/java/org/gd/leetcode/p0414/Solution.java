package org.gd.leetcode.p0414;

import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/third-maximum-number/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-02
 */
@LeetCode(
        name = "Third Maximum Number",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY
        }
)
class Solution {

    private long[] max;
    private int uniqueMax;

    private void put(int num) {
        for (int i = 0; i < max.length; i++) {
            if (num == max[i])
                break;
            if (num > max[i]) {
                shiftRight(i);
                max[i] = num;
                uniqueMax = Math.min(max.length, uniqueMax + 1);
                break;
            }
        }
    }

    private void shiftRight(int pos) {
        if (max.length - 1 - pos >= 0)
            System.arraycopy(max, pos, max, pos + 1, max.length - 1 - pos);
    }

    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        max = new long[3];
        Arrays.fill(max, Long.MIN_VALUE);
        uniqueMax = 0;

        for (int num : nums) {
            put(num);
        }

        return (int) (uniqueMax == 3 ? max[2] : max[0]);
    }
}
