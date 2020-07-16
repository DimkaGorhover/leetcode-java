package org.gd.leetcode.p0997;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/find-the-town-judge/
 */
@LeetCode(
        name = "Find the Town Judge",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.GRAPH
)
class Solution {

    public int findJudge(int N, int[][] trust) {

        if (trust.length == 0)
            return N <= 1 ? N : -1;

        int[] counts = new int[N + 1];
        for (int[] ints : trust) {
            counts[ints[0]]--;
            counts[ints[1]]++;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] >= N - 1)
                return i;
        }

        return -1;
    }
}
