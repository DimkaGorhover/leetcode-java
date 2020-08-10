package org.gd.leetcode.p0171;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 *
 * @see org.gd.leetcode.p0168.Solution
 * @since 2019-10-04
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Excel Sheet Column Number",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.MATH
)
class Solution {

    private static final int RADIX = 'Z' - 'A' + 1;

    public int titleToNumber(String s) {

        if (s == null)
            throw new NullPointerException();

        final int length = s.length();
        if (length <= 0)
            throw new IndexOutOfBoundsException();

        if (length == 1)
            return s.charAt(0) - 'A' + 1;

        int sum = 0;
        for (int index = 0; index < length; index++)
            sum = (sum * RADIX) + (s.charAt(index) + 1 - 'A');

        return sum;
    }
}
