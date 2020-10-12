package org.gd.leetcode.p1081;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 * https://www.youtube.com/watch?v=muDlIlVE1q4
 *
 * @see org.gd.leetcode.p0316.Solution
 * @since 2020-10-12
 */
@Repeat("Smallest Subsequence of Distinct Characters")
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Smallest Subsequence of Distinct Characters",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.STRING,
                LeetCode.Tags.STACK,
                LeetCode.Tags.GREEDY
        }
)
class Solution {

    public String smallestSubsequence(String s) {
        int[] table = new int['z' - 'a' + 1];
        final int length = s.length();
        for (int i = 0; i < length; i++) {
            table[s.charAt(i) - 'a'] = i;
        }
        boolean[] seen = new boolean[table.length];

        Stack stack = new FixedSizeStack(s.length());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen[c - 'a'])
                continue;

            while (!stack.isEmpty() && stack.peek() > c && i < table[stack.peek() - 'a'])
                seen[stack.pop() - 'a'] = false;

            stack.push(c);
            seen[c - 'a'] = true;
        }

        return stack.toString();
    }

    interface Stack {

        boolean isEmpty();

        int size();

        void push(char c);

        char pop();

        default char poll() { return pop(); }

        char peek();
    }

    static class FixedSizeStack implements Stack {

        private final char[] arr;
        private int index = -1;

        public FixedSizeStack(int capacity) {
            this.arr = new char[capacity];
        }

        @Override
        public boolean isEmpty() {
            return index < 0;
        }

        @Override
        public int size() {
            return index + 1;
        }

        @Override
        public void push(char c) {
            if (index + 1 == arr.length)
                throw new RuntimeException("stack is full");
            arr[++index] = c;
        }

        @Override
        public char pop() {
            char c = peek();
            index--;
            return c;
        }

        @Override
        public char peek() {
            if (index < 0)
                throw new RuntimeException("stack is empty");
            return arr[index];
        }

        @Override
        public String toString() {
            return new String(arr, 0, index + 1);
        }
    }
}
