package org.gd.leetcode.p0078;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@LeetCode(
        name = "Subsets",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.BACKTRACKING,
                LeetCode.Tags.BIT_MANIPULATION
        }
)
class Solution {

    private int[] nums;
    private int[] subset;
    private List<List<Integer>> result;

    private static List<Integer> copy(List<Integer> list, int value) {

        if (list == null || list.isEmpty())
            return Collections.singletonList(value);

        List<Integer> newList = new ArrayList<>(list.size() + 1);
        newList.addAll(list);
        newList.add(value);
        return newList;
    }

    private List<Integer> createList(int index, int value) {
        int listSize = index + 1;
        List<Integer> list = new ArrayList<>(listSize);
        subset[index] = value;
        for (int i = 0; i < listSize; i++)
            list.add(subset[i]);
        return list;
    }

    private void populate(List<Integer> list, int i) {
        if (i == nums.length)
            return;

        for (int j = i; j < nums.length; j++) {
            List<Integer> copy = copy(list, nums[j]);
            result.add(new ArrayList<>(copy));
            populate(copy, j + 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null)
            return Collections.emptyList();

        if (nums.length == 0)
            return Collections.singletonList(Collections.emptyList());

        if (nums.length == 1)
            return Arrays.asList(
                    Collections.emptyList(),
                    Collections.singletonList(nums[0])
            );

        this.nums = nums;
        this.subset = new int[nums.length];
        this.result = new ArrayList<>();
        result.add(Collections.emptyList());

        populate(null, 0);

        return result;
    }

    @Override
    public String toString() {
        return result == null ? "[]" : result.toString();
    }
}
