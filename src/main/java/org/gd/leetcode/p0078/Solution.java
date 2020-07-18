package org.gd.leetcode.p0078;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 */
@LeetCode(
        name = "Subsets",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.BACKTRACKING,
                LeetCode.Tags.BIT_MANIPULATION
        }
)
class Solution {

    private int[] nums;
    private List<List<Integer>> result;

    private static List<Integer> copy(List<Integer> list, int value) {

        if (list == null || list.isEmpty())
            return Collections.singletonList(value);

        List<Integer> newList = new ArrayList<>(list.size() + 1);
        newList.addAll(list);
        newList.add(value);
        return Collections.unmodifiableList(newList);
    }

    private void reset(int[] nums) {
        this.nums = nums;
        this.result = new ArrayList<>(1 << nums.length);
        result.add(Collections.emptyList());
    }

    private void populate(List<Integer> list, int i) {
        List<Integer> copy;
        for (int j = i; j < nums.length; j++) {
            result.add(copy = copy(list, nums[j]));
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
                    Collections.singletonList(nums[0]));

        reset(nums);
        populate(null, 0);
        return result;
    }

    @Override
    public String toString() {
        return result == null ? "[]" : result.toString();
    }
}
