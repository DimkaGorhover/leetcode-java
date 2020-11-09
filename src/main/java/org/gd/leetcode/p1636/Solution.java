package org.gd.leetcode.p1636;

import org.gd.leetcode.common.LeetCode;

/**
 * <a href="https://leetcode.com/problems/sort-array-by-increasing-frequency/" target="_blank">
 * 1636. Sort Array by Increasing Frequency
 * </a>
 *
 * <p>
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple
 * values have the same frequency, sort them in decreasing order.
 * </p>
 *
 * <p>
 * Return the sorted array.
 * </p>
 *
 * <p>Example 1:</p>
 * <code><pre>
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 * </pre></code>
 *
 * <p>Example 2:</p>
 * <code><pre>
 * Input: nums = [2,3,1,3,2]
 * Output: [1,3,3,2,2]
 * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
 * </pre></code>
 *
 * <p>
 * Example 3:
 * </p>
 * <code><pre>
 * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
 * Output: [5,-1,4,4,-6,-6,1,1,1]
 * </pre></code>
 *
 * Constraints:
 * <ul>
 * <li><code>1 <= nums.length <= 100</code></li>
 * <li><code>-100 <= nums[i] <= 100</code></li>
 * </ul>
 *
 * @author Horkhover D.
 * @since 2020-11-09
 */
@LeetCode(
        name = "Sort Array by Increasing Frequency",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.SORT
        }
)
class Solution {

    private static int[] freqTable(int[] nums) {
        int[] table = new int[201];
        for (int num : nums)
            table[num + 100]++;
        return table;
    }

    private static void insertionSort(int[] a, int[] table) {
        for (int i, k = 0; ++k < a.length; ) {
            int ai = a[i = k];
            int t_ai = table[ai + 100];

            if (t_ai < table[a[i - 1] + 100] || (t_ai == table[a[i - 1] + 100] && ai > a[i - 1])) {
                while (--i >= 0 && (t_ai < table[a[i] + 100] || (t_ai == table[a[i] + 100] && ai > a[i]))) {
                    a[i + 1] = a[i];
                }
                a[i + 1] = ai;
            }
        }
    }

    public int[] frequencySort(int[] nums) {
        if (nums == null)
            return new int[0];

        if (nums.length <= 1 || (nums.length == 2 && nums[0] == nums[1]))
            return nums;

        insertionSort(nums, freqTable(nums));
        return nums;
    }
}
