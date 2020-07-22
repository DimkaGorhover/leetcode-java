package org.gd.leetcode.p0090;

import org.gd.leetcode.common.LeetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/subsets-ii/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0078.Solution
 * @since 2019-02-12
 */
@SuppressWarnings({"JavadocReference", "DuplicatedCode", "unused"})
@LeetCode(
        name = "Subsets II",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.BACKTRACKING
        })
class Solution {

    private int[] nums;
    private Set<List<Integer>> set;
    private List<List<Integer>> result;

    private static List<Integer> copy(List<Integer> list, int value) {

        if (list == null || list.isEmpty())
            return Collections.singletonList(value);

        List<Integer> newList = new ArrayList<>(list.size() + 1);
        newList.addAll(list);
        newList.add(value);
        return newList;
    }

    private void reset(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        result = new ArrayList<>(1 << nums.length);
        set = new HashSet<>(result.size());
        result.add(Collections.emptyList());
    }

    private void populate(List<Integer> list, int i) {
        List<Integer> copy;
        for (int j = i; j < nums.length; j++) {
            add(copy = copy(list, nums[j]));
            populate(copy, j + 1);
        }
    }

    private void add(List<Integer> list) {
        if (set.contains(list))
            return;

        result.add(list);
        set.add(list);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
