package org.gd.leetcode.p1502;

import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;

@LeetCode(
        name = "Can Make Arithmetic Progression From Sequence",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.SORT
        }
)
class Solution {

    private static boolean isSorted(int[] arr) {

        int left = 0;
        int right = 1;

        while (right < arr.length && arr[left] == arr[right]) {
            left++;
            right++;
        }

        if (right == arr.length)
            return true;

        if (arr[left] > arr[right]) {

            for (; right < arr.length; left++, right++) {
                if (arr[left] < arr[right])
                    return false;
            }

        } else {

            for (; right < arr.length; left++, right++) {
                if (arr[left] > arr[right])
                    return false;
            }

        }
        return true;
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr == null)
            throw new NullPointerException();

        if (arr.length < 2)
            throw new IllegalArgumentException();

        if (!isSorted(arr))
            Arrays.sort(arr);

        final int diff = arr[1] - arr[0];
        for (int i = 1, j = 2; j < arr.length; i++, j++) {
            if (arr[j] - arr[i] != diff)
                return false;
        }

        return true;
    }
}
