package org.gd.leetcode.p0169;

import java.util.HashMap;

/**
 * @author Horkhover D.
 * @since 2020-07-13
 */
class HashMapSolution implements Solution {

    @Override
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[nums.length + 1];
        int maxCount = 0;
        for (int value : nums) {
            int count = map.compute(value, (num, c) -> 1 + (c == null ? 0 : c));
            arr[count] = value;
            maxCount = Math.max(maxCount, count);
        }

        if (maxCount < (nums.length >> 1))
            throw new RuntimeException("there is no majority element");

        return arr[maxCount];
    }
}
