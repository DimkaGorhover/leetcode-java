package org.gd.leetcode.p0001;

import org.gd.leetcode.common.LeetCode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * @see org.gd.leetcode.p0016.Solution
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
    difficulty = LeetCode.Level.EASY,
    state = LeetCode.State.DONE,
    tags = {LeetCode.Tags.ARRAY, LeetCode.Tags.HASH_TABLE})
class Solution {

    private static final int[] TWO_EL = {0, 1};

    static int[] hashTable(int[] nums, int fromIndex, int toIndex, int target) {
        switch (nums.length) {
            case 0:
            case 1: return null;
            case 2: return TWO_EL;
        }
        Integer                   j;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = fromIndex; i < toIndex; i++) {
            if ((j = map.get(target - nums[i])) != null)
                return new int[]{j, i};
            map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        return hashTable(nums, 0, nums.length, target);
    }
}
