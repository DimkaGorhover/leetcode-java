package org.gd.leetcode.p0001;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/two-sum/">1. Two Sum</a>
 */
public class Solution {

    private static final int[] TWO_EL = {0, 1};

    private static int[] hashTable(int[] nums, int target) {
        switch (nums.length) {
            case 2: return TWO_EL;
        }
        Integer                   j;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if ((j = map.get(target - nums[i])) != null)
                return new int[]{i, j};
            map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        return hashTable(nums, target);
    }
}
