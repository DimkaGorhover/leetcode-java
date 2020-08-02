package org.gd.leetcode.p0415;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/add-strings/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-02
 */
@LeetCode(
        name = "Add Strings",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.STRING
        }
)
class Solution {

    private static int num(String num, int pos) {
        return pos >= 0 ? num.charAt(pos) - '0' : 0;
    }

    private static char toChar(int num) {
        return (char) (num + '0');
    }

    public String addStrings(String num1, String num2) {

        int l1 = num1.length();
        int l2 = num2.length();
        char[] result = new char[Math.max(l1, l2) + 1];
        int i = result.length;
        int i1 = l1 - 1;
        int i2 = l2 - 1;
        int prev = 0;

        while (i1 >= 0 || i2 >= 0 || prev > 0) {
            int sum = prev + num(num1, i1) + num(num2, i2);
            prev = sum / 10;
            result[--i] = toChar(sum % 10);
            i1--;
            i2--;
        }

        return new String(result, i, result.length - i);
    }
}
