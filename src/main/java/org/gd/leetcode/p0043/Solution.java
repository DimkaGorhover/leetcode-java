package org.gd.leetcode.p0043;

import org.gd.leetcode.common.LeetCode;

/**
 * FIXME: https://leetcode.com/problems/multiply-strings
 *
 * http://math-prosto.ru/?page=pages/action-in-column/multi-in-column.php
 *
 * @author Gorkhover D.
 * @since 2018-10-22
 */
@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        tags = {
                LeetCode.Tags.MATH,
                LeetCode.Tags.STRING
        })
class Solution {

    public static void main(String[] args) {
        System.out.println(
                new Solution().multiply("427", "36")
        );
    }

    public String multiply(String num1, String num2) {
        int    pos1  = num1.length(), pos2 = num2.length(), pos = pos1 + pos2;
        char[] chars = new char[pos];
        java.util.Arrays.fill(chars, 0, pos, '0');

        while (pos1 >= 0 || pos2 >= 0) {


            pos1--;
            pos2--;
            pos--;
        }


        return new String(chars, chars[0] == 0 ? 1 : 0, chars.length);
    }
}
