package org.gd.leetcode.p0067;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/add-binary/
 *
 * @author Gorkhover D.
 * @since 2018-10-22
 */
@LeetCode(name = "Add Binary", state = LeetCode.State.DONE, difficulty = LeetCode.Level.EASY, tags = {LeetCode.Tags.MATH, LeetCode.Tags.STRING})
class Solution {

    public String addBinary(String a, String b) {

        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        int i = a.length() - 1, j = b.length() - 1, prev = 0, sum;

        char[] chars = new char[i + 2];
        while (i >= 0) {
            sum = prev + (a.charAt(i) - 48) + (j < 0 ? 0 : b.charAt(j) - 48);
            chars[i + 1] = (char) ((sum % 2) + 48);
            prev = sum / 2;
            i--;
            j--;
        }

        int start = 1;
        if (prev == 1)
            chars[start = 0] = '1';

        return new String(chars, start, (chars.length - start));
    }
}
