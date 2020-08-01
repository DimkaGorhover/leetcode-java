package org.gd.leetcode.p0150;

import java.util.LinkedList;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-01
 */
class Solution {

    private Stack stack;

    private void oneElement(char c) {
        switch (c) {
            case '+': {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v2 + v1);
                break;
            }
            case '-': {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v2 - v1);
                break;
            }
            case '*': {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v2 * v1);
                break;
            }
            case '/': {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v2 / v1);
                break;
            }
            default: {
                stack.push(c - '0');
            }
        }
    }

    private void handleNumber(String token) {
        int num = 0;
        int sign = 1;
        int i = 0;
        if (token.charAt(0) == '-') {
            sign = -1;
            i = 1;
        }

        for (; i < token.length(); i++) {
            num = (num * 10) + (token.charAt(i) - '0');
        }

        stack.push(num * sign);
    }

    public int evalRPN(String[] tokens) {

        if (tokens == null || tokens.length == 0)
            return 0;

        stack = new Stack();

        for (String token : tokens) {
            int length = token.length();
            if (length == 1) {
                oneElement(token.charAt(0));
            } else {
                handleNumber(token);
            }
        }

        return stack.pop();
    }

    static class Stack {

        private final LinkedList<Integer> ll = new LinkedList<>();

        void push(int value) {
            ll.addLast(value);
        }

        int pop() {
            return ll.removeLast();
        }
    }
}
