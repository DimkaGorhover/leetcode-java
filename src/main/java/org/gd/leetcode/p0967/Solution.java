package org.gd.leetcode.p0967;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 *
 * @since 2020-08-18
 */
@Repeat("stolen solution")
@LeetCode(
        name = "Numbers With Same Consecutive Differences",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DYNAMIC_PROGRAMMING,
                LeetCode.Tags.BREADTH_FIRST_SEARCH,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        }
)
class Solution {

    public int[] numsSameConsecDiff(int N, int K) {

        List<Integer> ans = new ArrayList<>();
        findAll(0, N, K, -1, ans);

        int[] ret = new int[ans.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = ans.get(i);

        return ret;

    }

    public static void findAll(int index, int n, int k, int cur, List<Integer> ans) {

        if (index == n) {
            ans.add(cur);
            return;
        }
        if (cur == 0 && n > 1)
            return;

        if (cur == -1) {
            for (int i = 0; i <= 9; i++) {
                findAll(index + 1, n, k, i, ans);
            }
        } else {

            int rem = cur % 10;

            if (rem + k <= 9)
                findAll(index + 1, n, k, cur * 10 + (rem + k), ans);

            if (k != 0 && rem - k >= 0)
                findAll(index + 1, n, k, cur * 10 + (rem - k), ans);
        }

    }
}
