package org.gd.leetcode.p0005;

/**
 * TODO: https://leetcode.com/problems/longest-palindromic-substring/
 */
class Solution {

    public String longestPalindrome(String s) {
        if (s == null)
            return null;
        int length = s.length();
        switch (length) {
            case 0: return s;
            case 1: return s;
            case 2: return s.charAt(0) == s.charAt(1) ? s : "";
        }

        throw new UnsupportedOperationException();
    }
}
