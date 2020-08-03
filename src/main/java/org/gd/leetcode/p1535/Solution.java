package org.gd.leetcode.p1535;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/find-the-winner-of-an-array-game/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-03
 */
@LeetCode(
        name = "Find the Winner of an Array Game",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY
        }
)
class Solution {

    public int getWinner(int[] arr, int k) {

        if (arr == null)
            throw new NullPointerException();

        if (arr.length == 0)
            throw new IllegalArgumentException();

        if (k <= 0)
            return arr[0];

        if (k >= arr.length) {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++)
                max = Math.max(max, arr[i]);
            return max;
        }

        int pos0 = 0;
        int pos1 = 1;
        int count = 0;
        while (count < k && pos1 < arr.length) {
            if (arr[pos0] < arr[pos1]) {
                arr[pos0] = arr[pos1];
                count = 1;
            } else {
                count++;
            }
            pos1++;
        }

        return arr[0];
    }
}
