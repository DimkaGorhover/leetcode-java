package org.gd.leetcode.p1306;

import org.gd.leetcode.common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/jump-game-iii/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0045.Solution
 * @see org.gd.leetcode.p0055.Solution
 * @since 2020-08-03
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Jump Game III",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.GRAPH,
                LeetCode.Tags.BREADTH_FIRST_SEARCH
        }
)
class Solution {

    public boolean canReach(int[] arr, int start) {
        if (arr == null) throw new NullPointerException();
        if (start < 0 || start >= arr.length) throw new IllegalArgumentException();
        if (start == arr.length - 1) return true;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {

            start = q.poll();

            if (arr[start] == 0)
                return true;

            if (arr[start] > 0) {

                int p = start + arr[start];
                int n = start - arr[start];

                if (p < arr.length)
                    q.add(p);

                if (n >= 0)
                    q.add(n);

                arr[start] = -arr[start];
            }
        }

        return false;
    }
}
