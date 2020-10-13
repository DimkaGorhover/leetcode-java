package org.gd.leetcode.p0043;

import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/multiply-strings
 *
 * http://math-prosto.ru/?page=pages/action-in-column/multi-in-column.php
 *
 * @author Gorkhover D.
 * @since 2018-10-22
 */
@LeetCode(
        name = "Multiply Strings",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.MATH,
                LeetCode.Tags.STRING
        })
class Solution {

    private static char c(int value) { return (char) (value + '0'); }

    private static int num(char c) { return c - '0'; }

    private static int num(String str, int pos) { return num(str.charAt(pos)); }

    public String multiply(String num1, String num2) {

        final int length1;
        if (num1 == null || (length1 = num1.length()) == 0)
            throw new IllegalArgumentException("num1");

        final int length2;
        if (num2 == null || (length2 = num2.length()) == 0)
            throw new IllegalArgumentException("num2");

        if (length2 == 1) {
            if (num2.charAt(0) == '0') return "0";
            if (num2.charAt(0) == '1') return num1;
            if (length1 == 1) {
                int m = num(num1, 0) * num(num2, 0);
                int i1 = m / 10;
                int i2 = m % 10;
                return new String(i1 > 0 ? new char[]{c(i1), c(i2)} : new char[]{c(i2)});
            }
        }

        if (length1 == 1) {
            if (num1.charAt(0) == '0') return "0";
            if (num1.charAt(0) == '1') return num2;
        }

        char[] res = new char[length1 + length2];
        Arrays.fill(res, '0');

        int resOffset = 1;
        for (int i = length2 - 1; i >= 0; i--) {
            int resI = res.length - resOffset;
            int prev = 0;
            for (int j = length1 - 1; j >= 0; j--) {
                int m = num(num1, j) * num(num2, i) + prev + num(res[resI]);
                prev = m / 10;
                res[resI--] = c(m % 10);
            }
            resOffset++;
            if (prev > 0)
                res[resI] = c(prev);
        }

        int startIndex = 0;
        while (res[startIndex] == '0')
            startIndex++;

        return new String(res, startIndex, res.length - startIndex);
    }
}
