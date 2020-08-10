package org.gd.leetcode.p0347;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Horkhover Dmytro
 * @see LinkedListSolution
 * @since 2020-08-10
 */
class SortSolution implements Solution {

    public int[] topKFrequent(int[] nums, int k) {

        Integer[] arr = new Integer[nums.length];
        Map<Integer, Integer> counts = new HashMap<>();
        int length = 0;

        for (int num : nums)
            if (counts.compute(num, (ignored, c) -> 1 + (c == null ? 0 : c)) == 1)
                arr[length++] = num;

        Arrays.sort(arr, 0, length, (o1, o2) -> Integer.compare(counts.get(o2), counts.get(o1)));

        int[] result = new int[Math.min(length, k)];
        for (int i = 0; i < result.length; i++)
            result[i] = arr[i];

        return result;
    }
}
