package org.gd.leetcode.p0374;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = {
                LeetCode.Tags.BINARY_SEARCH
        })
abstract class Solution {

    public int guessNumber(int n) {
        if (guess(0) == 0) return 0;
        if (guess(n) == 0) return n;
        int left = 0, right = n, mid, res;
        while (left <= right) {
            if ((res = guess(mid = (left + right) >>> 1)) == -1) {
                right = mid;
            } else if (res == 1) {
                left = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    abstract int guess(int n);
}
