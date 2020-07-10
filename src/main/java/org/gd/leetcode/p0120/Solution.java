package org.gd.leetcode.p0120;

import org.gd.leetcode.common.LeetCode;

import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 */
@LeetCode(
        name = "Triangle",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
class Solution {

    private static int first(List<Integer> list) {
        return list.get(0);
    }

    private static int last(List<Integer> list) {
        return list.get(list.size() - 1);
    }

    private static int addToFirst(List<Integer> list, int value) {
        return add(list, 0, value);
    }

    private static int addToLast(List<Integer> list, int value) {
        return add(list, list.size() - 1, value);
    }

    private static int add(List<Integer> list, int index, int value) {
        final int prev = list.get(index);
        final int newValue = prev + value;
        list.set(index, newValue);
        return newValue;
    }

    private static int computeCorners(List<Integer> parent, List<Integer> current) {
        final int first = addToFirst(current, first(parent));
        final int last = addToLast(current, last(parent));
        return Math.min(first, last);
    }

    private static int compute(List<Integer> parent, List<Integer> current, int index) {
        final int left = parent.get(index - 1);
        final int right = parent.get(index);
        int value = current.get(index);
        value = Math.min(value + left, value + right);
        current.set(index, value);
        return value;
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        final int height;
        if (triangle == null || (height = triangle.size()) == 0)
            return 0;

        List<Integer> parent = triangle.get(0);
        if (height == 1)
            return first(parent);

        List<Integer> current = triangle.get(1);
        int min = computeCorners(parent, current);
        if (height == 2)
            return min;

        parent = current;
        for (int level = 2; level < height; level++) {

            min = computeCorners(parent, current = triangle.get(level));

            for (int index = 1, lastIndex = current.size() - 1; index < lastIndex; index++)
                min = Math.min(min, compute(parent, current, index));

            parent = current;
        }

        return min;
    }
}
