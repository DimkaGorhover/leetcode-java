package org.gd.leetcode.p0567;

import org.gd.leetcode.common.LeetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/permutation-in-string/
 *
 * FIXME: slow solution
 *
 * @author Horkhover Dmytro
 * @since 2020-07-25
 */
@LeetCode(
        name = "Permutation in String",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TWO_POINTERS,
                LeetCode.Tags.SLIDING_WINDOW
        }
)
class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (Objects.equals(s1, s2))
            return true;

        Permutation permutation = Permutation.of(s1);
        Permutation p = permutation.copy();
        for (int i = 0; i < s2.length(); i++) {
            final char c = s2.charAt(i);
            if (p.contains(c)) {
                p.acquire(c);
            } else if (p.count != permutation.count) {
                i = i - permutation.diff(p);
                p = permutation.copy();
            }
            if (p.isEmpty())
                return true;
        }

        return false;
    }

    static class Permutation {

        private final int[] quotas;
        private int count;

        Permutation(int[] quotas, int count) {
            this.quotas = quotas;
            this.count = count;
        }

        static Permutation of(String s) {
            final int length = s.length();
            final int[] set = new int['z' - 'a' + 1];
            int count = 0;
            for (int i = 0; i < length; i++) {
                set[s.charAt(i) - 'a']++;
                count++;
            }
            return new Permutation(set, count);
        }

        Permutation copy() {
            return new Permutation(Arrays.copyOf(quotas, quotas.length), count);
        }

        boolean contains(char c) { return quotas[c - 'a'] > 0; }

        boolean isEmpty() { return count == 0; }

        int diff(Permutation permutation) {
            return Math.abs(permutation.count - count);
        }

        void acquire(char c) {
            quotas[c - 'a']--;
            count--;
        }
    }
}
