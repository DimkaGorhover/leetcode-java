package org.gd.leetcode.p0066;

/**
 * @author Gorkhover D.
 * @since 2018-10-22
 */
class Solution {

    public int[] plusOne(int[] digits) {
        int prev = 0;
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            final int sum = digits[i] + prev;
            digits[i] = sum % 10;
            prev = sum / 10;
        }
        if (prev != 0) {
            final int[] newInts = new int[digits.length + 1];
            newInts[0] = prev;
            System.arraycopy(digits, 0, newInts, 1, digits.length);
            digits = newInts;
        }
        return digits;
    }
}
