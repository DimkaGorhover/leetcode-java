package org.gd.leetcode.p0374;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */
@LeetCode(
        name = "Guess Number Higher or Lower",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BINARY_SEARCH
        })
class Solution extends GuessGame {

    public int guessNumber(int n) {
        if (guess(0) == 0) return 0;
        if (guess(n) == 0) return n;

        int left = 0;
        int right = n;

        while (left <= right) {

            int mid = (left + right) >>> 1;
            int compare = guess(mid);

            if (compare > 0) {
                left = mid + 1;
            } else if (compare < 0) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
