package org.gd.leetcode.p2283;

import org.gd.leetcode.common.LeetCode;

/**
 * <a href="https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/">LeetCode #2283: Check if Number Has Equal Digit Count and Digit Value</a>
 *
 * @author Horkhover Dmytro
 * @since 2022-09-27
 */
@LeetCode(
        name = "Check if Number Has Equal Digit Count and Digit Value",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.STRING
        }
)
class Solution {

    public boolean digitCount(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
        int[] ht = new int[10];
        int n = num.length();
        for (int i = 0; i < n; i++) {
            ht[num.charAt(i) - '0']++;
        }
        for (int i = 0; i < n; i++) {
            if (ht[i] != num.charAt(i) - '0') {
                return false;
            }
        }
        return true;
    }
}
