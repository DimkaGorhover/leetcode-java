package org.gd.leetcode.p0239;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-28
 */
class TreeMapSolution implements Solution {

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

        SlidingWindow sw = new Tree();
        for (int i = 0; i < k; i++)
            sw.put(nums[i]);

        int[] result = new int[nums.length - k + 1];
        result[0] = sw.max();

        for (int i = k; i < nums.length; i++) {
            sw.remove(nums[i - k]);
            sw.put(nums[i]);
            result[i - k + 1] = sw.max();
        }

        return result;
    }

    interface SlidingWindow {

        int max();

        void remove(int value);

        void put(int value);
    }

    static class Tree implements SlidingWindow, Comparator<Integer> {

        private final TreeMap<Integer, Integer> map = new TreeMap<>(this);

        @Override
        public int max() {
            return map.firstKey();
        }

        @Override
        public void remove(int value) {
            if (map.compute(value, (k, quota) -> (quota == null ? 0 : quota) - 1) == 0)
                map.remove(value);
        }

        @Override
        public void put(int value) {
            map.compute(value, (k, quota) -> 1 + (quota == null ? 0 : quota));
        }

        @Override
        public String toString() {
            return map.toString();
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o2, o1);
        }
    }
}
