package org.gd.leetcode.p0005;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * @see org.gd.leetcode.p0226.Solution
 */
@SuppressWarnings({"JavadocReference"})
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = {LeetCode.Tags.STRING, LeetCode.Tags.DYNAMIC_PROGRAMMING})
class Solution {

/*
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int len = 0;
        int start = 0;
        if(s.length() == 1)
            return s;
        for(int i = 0; i < n-1; i++){
            int len1 = is_Palindromic(s, i, i);
            int len2 = is_Palindromic(s, i, i + 1);
            int prev = len ;
            len = Math.max(len1, len2);
            len = Math.max(len, prev);
            if(prev != len)
                start = i-(len-1)/2;
        }
        return s.substring(start,start + len);
    }
    private int is_Palindromic(String s, int i, int j){
        int L = i;
        int R = j;
        while(L >= 0 && R < s.length() && L<=R && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;
    }
}
*/

    static String getPalindrome(String s, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > s.length())
            throw new IndexOutOfBoundsException();

        final int length = endIndex - startIndex;
        switch (length) {
            case 0:
            case 1: return "" + s.charAt(startIndex);
            case 2: {
                char c1 = s.charAt(startIndex);
                char c2 = s.charAt(startIndex + 1);
                return c1 + "" + (c1 == c2 ? c2 : "");
            }
        }

        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(startIndex + i) != s.charAt(endIndex - 1 - i))
                return "";
        }

        if (startIndex == 0 && endIndex == s.length())
            return s;

        return s.substring(startIndex, endIndex);
    }

    public String longestPalindrome(String s) {
        if (s == null)
            return null;
        final int length = s.length();
        switch (length) {
            case 0:
            case 1: return s;
            case 2: {
                char c1 = s.charAt(0);
                return c1 == s.charAt(1) ? s : ("" + c1);
            }
        }

        String maxPalindrome = "";
        for (int startIndex = 0; startIndex < length && maxPalindrome.length() < (length - startIndex); startIndex++) {
            for (int endIndex = startIndex + 1; endIndex <= length; endIndex++) {
                String palindrome = getPalindrome(s, startIndex, endIndex);
                if (palindrome.length() > maxPalindrome.length())
                    maxPalindrome = palindrome;
            }
        }
        return maxPalindrome;
    }
}
