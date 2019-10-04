package org.gd.leetcode.p1207;

import org.gd.leetcode.common.LeetCode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/
 *
 * @since 2019-10-04
 */
@LeetCode(difficulty = LeetCode.Level.EASY, tags = LeetCode.Tags.HASH_TABLE)
class Solution {

    public boolean uniqueOccurrences(int[] arr) {

        if (arr == null || arr.length == 0)
            return true;

        if (arr.length == 1)
            return true;

        if (arr.length == 2)
            return arr[0] == arr[1];

        HashMap<Integer, Integer> counts = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            int count = counts.getOrDefault(value, 0) + 1;
            counts.put(value, count);
            max = Math.max(max, count);
        }
        boolean[] set = new boolean[max];
        for (int value : counts.values()) {
            if (set[value - 1])
                return false;
            set[value - 1] = true;
        }
        return true;
    }
}
