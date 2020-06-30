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
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int profit;
        for (int price : prices) {
            if (price < minPrice)
                minPrice = price;
            else if ((profit = price - minPrice) > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }
}
