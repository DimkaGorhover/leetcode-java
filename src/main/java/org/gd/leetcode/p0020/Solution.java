package org.gd.leetcode.p0020;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0022.Solution
 * @since 2018-12-29
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = {
                LeetCode.Tags.STACK,
                LeetCode.Tags.STRING
        })
class Solution {

    private final byte[] hashTable;

    public Solution() {
        hashTable = new byte[Byte.MAX_VALUE];
        hashTable[')'] = '(';
        hashTable[']'] = '[';
        hashTable['}'] = '{';
    }

    public boolean isValid(String s) {

        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        int[] stack = new int[s.length()];

        int c, mapped, head = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            mapped = hashTable[c];
            if (mapped > 0) {
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
