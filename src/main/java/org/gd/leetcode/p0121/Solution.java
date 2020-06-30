package org.gd.leetcode.p0121;

import org.gd.leetcode.common.LeetCode;

/**
 * TODO: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author Horkhover D.
 * @see org.gd.leetcode.p0053.Solution
 * @since 2020-06-30
 */
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
class Solution {

    public int maxProfit(int[] prices) {
        int max0 = prices[0];
        int max1 = prices[0];

        for (int i = 1, n = prices.length; i < n; i++) {

            max1 = Math.max(max1 - prices[i], prices[i]);

            max0 = Math.max(max0, max1);
        }
        return max0;
    }
}
