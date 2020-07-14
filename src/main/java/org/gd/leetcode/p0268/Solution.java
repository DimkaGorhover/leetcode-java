package org.gd.leetcode.p0268;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/missing-number/
 *
 * @author Horkhover D.
 * @since 2020-07-14
 */
@LeetCode(
        name = "Missing Number",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.MATH,
                LeetCode.Tags.BIT_MANIPULATION
        }
)
class Solution {

    public int missingNumber(int[] nums) {

        if (nums == null)
            throw new NullPointerException();

        if (nums.length == 1)
            return nums[0] > 0 ? 0 : 1;

        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);

        boolean[] arr = new boolean[max + 1];
        for (int num : nums)
            arr[num] = true;

        for (int i = 0; i < arr.length; i++)
            if (!arr[i])
                return i;

        return max + 1;
    }

/*
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
 */

/*
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
 */
}
