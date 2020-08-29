package org.gd.leetcode.p0969;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/pancake-sorting/
 *
 * <ul>
 * <li>https://www.geeksforgeeks.org/pancake-sorting/</li>
 * </ul>
 *
 * @since 2020-08-29
 */
@LeetCode(
        name = "Pancake Sorting",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
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

    private static void flip(int[] arr, final int k) {
        for (int i = 0, j = k; i < j; i++, j--)
            swap(arr, i, j);
    }

    private static int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i])
                return false;
        }
        return true;
    }

    public List<Integer> pancakeSort(int[] arr) {

        if (arr == null || arr.length <= 1 || isSorted(arr))
            return Collections.emptyList();

        List<Integer> ans = new ArrayList<>();
        for (int valueToSort = arr.length; valueToSort > 0; valueToSort--) {

            int index = find(arr, valueToSort);
            if (index == valueToSort - 1)
                continue;

            if (index != 0) {
                ans.add(index + 1);
                flip(arr, index);
            }

            ans.add(valueToSort);
            flip(arr, valueToSort - 1);
        }

        return ans;
    }
}
