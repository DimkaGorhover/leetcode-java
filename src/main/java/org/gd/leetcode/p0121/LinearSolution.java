package org.gd.leetcode.p0121;

/**
 * @author Horkhover D.
 * @see org.gd.leetcode.p0053.Solution
 * @since 2020-06-30
 */
class LinearSolution {

    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0, n = prices.length; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return Math.max(0, maxProfit);
    }
}
