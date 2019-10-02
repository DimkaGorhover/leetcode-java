package org.gd.leetcode.p0008;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = {
        LeetCode.Tags.MATH,
        LeetCode.Tags.STRING
})
class Solution {

    private static final int PREV_MAX_INT = Integer.MAX_VALUE / 10;
    private static final int P = Integer.MAX_VALUE % 10;

    public int myAtoi(String str) {
        if (str == null)
            return 0;
        int sign = 1, i = 0, n = str.length(), r = 0;
        while (i < n && str.charAt(i) == ' ')
            i++;
        if (i >= n)
            return 0;
        switch (str.charAt(i)) {
            case '-': sign = -1;
            case '+': i++;
        }
        while (i < n) {
            int num = str.charAt(i) - '0';
            if (num < 0 || num > 9) break;
            if (r > PREV_MAX_INT || PREV_MAX_INT == r && P < num)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            r = 10 * r + num;
            i++;
        }
        return sign * r;
    }
}
