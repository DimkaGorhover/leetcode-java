package org.gd.leetcode.p0155;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/min-stack/
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   // --> Returns -3.
 * minStack.pop();
 * minStack.top();      // --> Returns 0.
 * minStack.getMin();   // --> Returns -2.
 *
 * @since 2019-09-10
 */
@LeetCode(
        name = "Min Stack",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.STACK,
                LeetCode.Tags.DESIGN
        })
interface MinStack {

    void push(int x);

    void pop();

    int top();

    int getMin();
}
