package org.gd.leetcode.p1200;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-absolute-difference/
 *
 * @author Horkhover D.
 * @since 2020-11-19
 */
@LeetCode(
        name = "Minimum Absolute Difference",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.ARRAY
)
class Solution {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        if (arr == null || arr.length <= 1)
            return Collections.emptyList();

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int capacity = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            final int diff = arr[i + 1] - arr[i];
            if (diff == min) {
                capacity++;
            } else if (diff < min) {
                min = diff;
                capacity = 1;
            }
        }
        List<List<Integer>> result = new ArrayList<>(capacity);
        for (int i = 0; i < arr.length - 1; i++) {
            final int el1 = arr[i];
            final int el2 = arr[i + 1];
            final int diff = el2 - el1;
            if (diff == min) {
                result.add(Arrays.asList(el1, el2));
            }
        }
        return result;
    }
}
