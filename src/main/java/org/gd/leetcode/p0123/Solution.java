package org.gd.leetcode.p0123;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * @see org.gd.leetcode.p0121.Solution
 * @since 2020-08-16
 */
@SuppressWarnings({"JavadocReference", "SpellCheckingInspection"})
@Repeat("FUUUUUCKING DYNAMIC PROGRAMMING")
@LeetCode(
        name = "Best Time to Buy and Sell Stock III",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
interface Solution {

    int maxProfit(int[] prices);
}
