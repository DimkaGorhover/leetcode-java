package org.gd.leetcode.p0003;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
class Solution {

    private static int mask(int mask, int value) {
        return mask | (value ^ (value << 8));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        final int length = s.length();
        switch (length) {
            case 0: return 0;
            case 1: return 1;
            case 2: return s.charAt(0) == s.charAt(1) ? 1 : 2;
        }
        int[] index = new int[128];
        int max = 1;
        int c;
        for (int i = 0, j = 0; j < length; j++) {
            i = Math.max(index[c = s.charAt(j)], i);
            max = Math.max(max, j - i + 1);
            index[c] = j + 1;
        }
        return max;

    }
}
