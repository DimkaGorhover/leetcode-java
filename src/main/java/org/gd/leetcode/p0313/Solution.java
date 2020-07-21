package org.gd.leetcode.p0313;

import org.gd.leetcode.common.LeetCode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/super-ugly-number/
 *
 * @see org.gd.leetcode.p0264.Solution
 */
@SuppressWarnings({"JavadocReference", "ConstantConditions"})
@LeetCode(
        name = "Super Ugly Number",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.MATH,
                LeetCode.Tags.HEAP,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {

        int[] dp = new int[n];
        dp[0] = 1;

        EntryFactory ef = new EntryFactory(dp);
        PriorityQueue<Entry> q = new PriorityQueue<>();
        for (int prime : primes)
            q.add(ef.create(prime));

        int i = 1;
        while (i < n) {
            final Entry entry = q.poll();
            final int value = entry.peek();

            if (dp[i - 1] != value)
                dp[i++] = value;

            entry.next();
            q.add(entry);
        }

        return dp[n - 1];
    }

    static class EntryFactory {

        private final int[] dp;

        EntryFactory(int[] dp) { this.dp = dp; }

        Entry create(int prime) { return new Entry(dp, prime); }
    }

    static class Entry implements Comparable<Entry> {

        private final int[] dp;
        private final int multiplier;
        private int index;

        Entry(int[] dp, int multiplier) {
            this.dp = dp;
            this.multiplier = multiplier;
        }

        int peek() { return dp[index] * multiplier; }

        void next() { index++; }

        @Override
        public int compareTo(Entry o) { return Integer.compare(peek(), o.peek()); }
    }
}
