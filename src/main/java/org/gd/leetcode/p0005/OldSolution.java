package org.gd.leetcode.p0005;

/**
 * @author Horkhover Dmytro
 * @since 2022-01-28
 */
class OldSolution implements Solution {

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
