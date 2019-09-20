package org.gd.leetcode.p0060;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/permutation-sequence/
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
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
