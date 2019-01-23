package org.gd.leetcode.p0060;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/permutation-sequence/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-20
 */
@SuppressWarnings("WeakerAccess")
@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        tags = {
                LeetCode.Tags.MATH,
                LeetCode.Tags.BACKTRACKING
        })
class Solution {

    static final int[] FACTORIAL = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    static int remove(char[] array, int i, int length) {
        final int newLength = length - 1;
        System.arraycopy(array, i + 1, array, i, newLength - i);
        return newLength;
    }

    public String getPermutation(int n, int k) {
        int    nl      = n;
        char[] numbers = new char[n];
        for (int i = 0; i < n; i++)
            numbers[i] = (char) ('1' + i);
        k--;
        char[] chars = new char[n];
        for (int i = 1; i <= n; i++) {
            int index = k / FACTORIAL[n - i];
            chars[i - 1] = numbers[index];
            nl = remove(numbers, index, nl);
            k -= index * FACTORIAL[n - i];
        }
        return new String(chars);
    }
}
