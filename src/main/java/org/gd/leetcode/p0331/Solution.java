package org.gd.leetcode.p0331;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 *
 * Solution: https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78551/7-lines-Easy-Java-Solution
 *
 * @since 2020-09-25
 */
@Repeat("Verify Preorder Serialization of a Binary Tree")
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
        int diff = 1;

        StringItr itr = new StringItr(preorder);
        while (itr.hasNext()) {

            Integer node = itr.next();

            if (--diff < 0)
                return false;

            if (node != null)
                diff += 2;
        }

        return diff == 0;
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

            if (i >= length)
                return false;

            skip();

            if (preorder.charAt(i) == '#') {
                i++;
                next = null;
                return hasNext = true;
            }

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
