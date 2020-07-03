package org.gd.leetcode.p0003;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
@LeetCode(
        name = "longest substring without repeating characters",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.TWO_POINTERS,
                LeetCode.Tags.STRING,
                LeetCode.Tags.SLIDING_WINDOW
        }
)
class Solution {

    @SuppressWarnings("unused")
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

        int[] index = new int[1 << 7];
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
