package org.gd.leetcode.p0239;

import org.gd.leetcode.common.Repeat;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Horkhover Dmytro
 * @see Solution
 * @since 2020-07-28
 */
@SuppressWarnings("ConstantConditions")
@Repeat("sliding windows max deque solution")
class DequeSolution implements Solution {

    private static int linearMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++)
            max = Math.max(max, nums[i]);
        return max;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || nums.length == 1 || k == 1)
            return nums;

        if (nums.length == k)
            return new int[]{linearMax(nums)};

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>(k);
        for (int i = 0; i < nums.length; i++) {

            while (!q.isEmpty() && q.peekFirst() <= i - k)
                q.pollFirst();

            while (!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();

            q.offerLast(i);
            if (i >= k - 1)
                result[i - k + 1] = nums[q.peekFirst()];

        }
        return result;
    }
}
