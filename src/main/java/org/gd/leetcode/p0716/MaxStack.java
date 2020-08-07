package org.gd.leetcode.p0716;

import org.gd.leetcode.common.LeetCode;

/**
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0155.MinStack
 * @since 2020-08-07
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Max Stack",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.PAID,
        tags = {
                LeetCode.Tags.STACK,
                LeetCode.Tags.DESIGN
        }
)
interface MaxStack {

    void push(int x);

    void pop();

    int top();

    int getMax();
}
