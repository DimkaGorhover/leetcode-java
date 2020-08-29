package org.gd.leetcode.p0969;

import org.gd.leetcode.common.LeetCode;

import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/pancake-sorting/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-29
 */
@LeetCode(
        name = "Pancake Sorting",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.SORT
        }
)
class Solution {

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void reverse(int[] arr, final int k) {
        for (int left = 0, right = k; left < right; left++, right--)
            swap(arr, left, right);
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i])
                return false;
        }
        return true;
    }

    public List<Integer> pancakeSort(int[] A) {
        if (A == null || A.length <= 1 || isSorted(A))
            return Collections.emptyList();

        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }
}
