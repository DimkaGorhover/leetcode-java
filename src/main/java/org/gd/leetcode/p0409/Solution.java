package org.gd.leetcode.p0409;

/**
 * https://leetcode.com/problems/longest-palindrome/
 *
 * @author Horkhover D.
 * @since 2020-07-13
 */
class Solution {

    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i++)
            arr[s.charAt(i)]++;

        int length = 0;
        int odd = 0;
        for (int value : arr) {
            if (value % 2 == 0) {length += value;}
            else

        }
        return length + maxOdd;
    }
}
