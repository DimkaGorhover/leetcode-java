package org.gd.leetcode.p0076;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-16
 */
@LeetCode(
        name = "Minimum Window Substring",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.TWO_POINTERS,
                LeetCode.Tags.STRING,
                LeetCode.Tags.SLIDING_WINDOW
        }
)
class Solution {

    public String minWindow(String s, String t) {

        final int sLen = s.length();
        if (sLen < t.length())
            return "";

        CharsSet set = new CharsSet(t);

        int start = 0, end = 0;
        int i = 0, j = 0;
        int minLength = Integer.MAX_VALUE;

        while (j < sLen) {

            while (set.hasMore() && j < sLen)
                set.acquire(s.charAt(j++));

            if (set.hasMore() && j == s.length())
                break;

            int prevI = i;
            while (!set.hasMore()) {
                set.release(s.charAt(i++));
                prevI = i - 1;
            }

            int length = j - prevI;
            if (length < minLength) {
                minLength = length;
                start = prevI;
                end = j;
            }
        }

        return s.substring(start, end);
    }

    static class CharsSet {

        private final boolean[] set;
        private final int[] window;
        private final int count;
        private int acquires = 0;

        CharsSet(String t) {

            set = new boolean[1 << 7];
            window = new int[1 << 7];

            int count = 0;
            for (int i = 0; i < t.length(); i++) {
                set[t.charAt(i)] = true;
                window[t.charAt(i)]++;
                count++;
            }

            this.count = count;
        }

        boolean hasMore() {
            return acquires < count;
        }

        void acquire(char c) {
            if (set[c]) {
                int count = window[c]--;
                if (count > 0)
                    acquires++;
            }
        }

        void release(char c) {
            if (set[c]) {
                int count = ++window[c];
                if (count > 0)
                    acquires--;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (int i = 0; i < set.length; i++) {
                if (set[i]) {
                    if (!first)
                        sb.append(", ");
                    first = false;
                    sb.append((char) i).append("=").append(window[i]);
                }
            }
            return sb.toString();
        }
    }
}
