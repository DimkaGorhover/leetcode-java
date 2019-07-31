package org.gd.leetcode.p0020;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-29
 */
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = {
                LeetCode.Tags.STACK,
                LeetCode.Tags.STRING
        })
class Solution {

    private static int map(int c) {
        switch (c) {
            case ')': return '(';
            case ']': return '[';
            case '}': return '{';
        }
        return -1;
    }

    public boolean isValid(String s) {

        int[] stack = new int[s.length()];

        int c, mapped, head = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((mapped = map(c = s.charAt(i))) > 0) {
                int top = head <= 0 ? -2 : stack[--head];
                if (top != mapped)
                    return false;
            } else {
                stack[head++] = c;
            }
        }
        return head == 0;
    }
}
