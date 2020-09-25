package org.gd.leetcode.p0331;

import org.gd.leetcode.common.LeetCode;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 *
 * @author Horkhover Dmytro
 * @since 2020-09-25
 */
@LeetCode(
        name = "Verify Preorder Serialization of a Binary Tree",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.STACK
        }
)
class Solution {

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.isEmpty())
            return false;

        Stack stack = new Stack();



        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }

    static class Stack {

        private final Deque<Integer> deque = new LinkedList<>();

        boolean isEmpty() {
            return deque.isEmpty();
        }

        void push(int value) {
            deque.addFirst(value);
        }

        int pop() {
            return deque.pollFirst();
        }
    }

    static class StringItr implements Iterator<Integer> {

        private final String preorder;
        private final int length;

        private int i = 0;
        private boolean hasNext = false;
        private Integer next = null;

        StringItr(String preorder) {
            this.preorder = preorder;
            length = preorder.length();
        }

        private void skip() {
            for (; i < length; i++) {
                char c = preorder.charAt(i);
                if (c != ' ' && c != ',')
                    break;
            }
        }

        @Override
        public boolean hasNext() {
            if (hasNext)
                return true;

            skip();

            int n = 0;
            int sign = 1;
            boolean hasNumber = false;
            boolean hasSign = false;
            for (; i < length; i++) {
                char c = preorder.charAt(i);
                if (c == '-' && !hasSign) {
                    sign = -1;
                    hasSign = true;
                    continue;
                }
                if (c == ',' || c == ' ') {
                    next = n * sign;
                    return hasNext = true;
                }
                if (c == '#') {
                    next = null;
                    return hasNext = true;
                }
                n = (n * 10) + (c - '0');
                hasNumber = true;
                hasSign = true;
            }

            next = n * sign;

            return hasNext = hasNumber;
        }

        @Override
        public Integer next() {
            if (!hasNext())
                throw new NoSuchElementException();

            hasNext = false;
            return next;
        }
    }
}
