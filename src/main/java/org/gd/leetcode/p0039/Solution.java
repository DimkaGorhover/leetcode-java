package org.gd.leetcode.p0039;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 *
 * @see org.gd.leetcode.p0040.Solution
 */
@SuppressWarnings({"JavadocReference", "DuplicatedCode"})
@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.BACKTRACKING
        }
)
class Solution {

    private int[] candidates;
    private int target;
    private List<List<Integer>> results = null;

    private static List<List<Integer>> singleValue(int value, int target) {
        if (target % value != 0)
            return Collections.emptyList();

        int size = target / value;
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
            list.add(value);

        return Collections.singletonList(list);
    }

    private static List<Integer> addAndCopy(List<Integer> list, int value) {
        if (list.isEmpty())
            return Collections.singletonList(value);

        List<Integer> newList = new ArrayList<>(list.size() + 1);
        newList.addAll(list);
        newList.add(value);
        return newList;
    }

    private static boolean isSorted(int[] arr) {
        if (arr.length <= 1)
            return true;
        for (int i = 0, j = 1; j < arr.length; i++, j++) {
            int prev = arr[i];
            if (prev > arr[j]) {
                arr[i] = arr[j];
                arr[j] = prev;
                return false;
            }
        }
        return true;
    }

    private void combine(List<Integer> list, int sum, int start) {
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            int nextSum = sum + candidate;
            if (nextSum == target) {
                results.add(addAndCopy(list, candidate));
                break;
            } else if (nextSum > target) {
                break;
            } else {
                combine(addAndCopy(list, candidate), nextSum, i);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return Collections.emptyList();

        if (candidates.length == 1)
            return singleValue(candidates[0], target);

        this.target = target;
        this.results = new ArrayList<>();
        this.candidates = candidates;

        if (!isSorted(candidates))
            Arrays.sort(candidates);

        combine(Collections.emptyList(), 0, 0);

        return results;
    }
}
