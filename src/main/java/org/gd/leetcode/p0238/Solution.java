package org.gd.leetcode.p0238;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of
 * all the elements of nums except nums[i].
 *
 * <pre><code>
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Note: Please solve it without division and in O(n).
 *
 * </code></pre>
 *
 * Follow up: Could you solve it with constant space complexity? (The output array does not count as extra space for the
 * purpose of space complexity analysis.)
 *
 * @since 2019-10-09
 */
@Repeat("i've stolen this solution! Shame on me! :( ")
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = LeetCode.Tags.ARRAY)
class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < answer.length; i++)
            answer[i] = answer[i - 1] * nums[i - 1];
        int right = 1;
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }
        return answer;
    }
}
