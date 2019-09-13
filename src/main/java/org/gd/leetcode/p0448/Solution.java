package org.gd.leetcode.p0448;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 *
 * @since 2019-09-13
 */
@LeetCode(difficulty = LeetCode.Level.EASY, tags = {LeetCode.Tags.ARRAY})
class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();

        if (nums.length == 1 && nums[0] != 1)
            return Collections.singletonList(1);

        int[] hashTable = new int[nums.length];
        for (int num : nums)
            hashTable[num - 1] = 1;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            if (hashTable[i] == 0)
                list.add(i + 1);

        return list;
    }
}
