package org.gd.leetcode.p0005;

/**
 * @author Horkhover Dmytro
 * @since 2022-01-28
 */
class NewSolution implements Solution {

    public String longestPalindrome(String text) {

        final int n;
        if (text == null || text.isEmpty() || (n = text.length()) == 1) {
            return text;
        }

        int len = 0;
        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            int prev = len;
            len = Math.max(prev, Math.max(
                    expandPalindrome(text, i, i),
                    expandPalindrome(text, i, i + 1)
            ));
            if (prev != len) {
                start = i - ((len - 1) >> 1);
            }
        }

        return text.substring(start, start + len);
    }

    private static int expandPalindrome(String text, int left, int right) {
        while (left >= 0 && right < text.length() && left <= right && text.charAt(left) == text.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
