package org.gd.leetcode.p0215;

import java.util.PriorityQueue;

/**
 * @author Horkhover Dmytro
 * @see SortSolution
 * @since 2022-01-31
 */
class HeapSolution implements Solution {

    @Override
    public int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            throw new NullPointerException("nums cannot be null");
        }

        if (k < 0) {
            throw new IllegalArgumentException("k cannot be less than 0");
        }

        if (k >= nums.length) {
            throw new IllegalArgumentException("k cannot be more than length of array");
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
        }

        while (k > 0) {
            heap.poll();
            k--;
        }

        //noinspection ConstantConditions
        return heap.poll();
    }
}
