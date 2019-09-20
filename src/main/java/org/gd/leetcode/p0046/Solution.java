package org.gd.leetcode.p0046;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

/**
 * https://leetcode.com/problems/permutations/
 *
 * @see org.gd.leetcode.p0077.Solution
 * @since 2019-09-20
 */
@SuppressWarnings("JavadocReference")
@LeetCode(difficulty = LeetCode.Level.MEDIUM)
class Solution {

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0)
            return Collections.emptyList();

        if (nums.length == 1)
            return singletonList(
                    singletonList(nums[0])
            );

        if (nums.length == 2)
            return asList(
                    asList(nums[0], nums[1]),
                    asList(nums[1], nums[0])
            );

        final ArrayList<Integer> integers = new ArrayList<>(nums.length);
        for (int num : nums)
            integers.add(num);

        return permute(
                new ArrayList<>(0),
                integers);
    }

    private static List<List<Integer>> permute(List<Integer> prefix, List<Integer> str) {

        int n = str.size();
        if (n == 0)
            return singletonList(prefix);

        final List<List<Integer>> sum = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            ArrayList<Integer> list1 = new ArrayList<>(prefix);
            list1.add(str.get(i));

            ArrayList<Integer> list2 = new ArrayList<>();
            list2.addAll(str.subList(0, i));
            list2.addAll(str.subList(i + 1, n));

            sum.addAll(permute(list1, list2));
        }
        return sum;
    }
}
