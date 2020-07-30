package org.gd.leetcode.p1281;

import org.gd.leetcode.common.LeetCode;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-30
 */
@LeetCode(
        name = "Subtract the Product and Sum of Digits of an Integer",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.MATH
        }
)
class Solution {

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }
        return product - sum;
    }
}
