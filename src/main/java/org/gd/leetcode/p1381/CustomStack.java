package org.gd.leetcode.p1381;

import org.gd.leetcode.common.LeetCode;

import java.util.StringJoiner;

/**
 * https://leetcode.com/problems/design-a-stack-with-increment-operation/
 */
@LeetCode(
        name = "Design a Stack With Increment Operation",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.STACK,
                LeetCode.Tags.DESIGN
        }
)
class CustomStack {

    private final int[] arr;
    private final int[] inc;
    private int cursor = -1;

    public CustomStack(int maxSize) {
        arr = new int[maxSize = Math.max(0, maxSize)];
        inc = new int[maxSize];
    }

    public void push(int x) {
        if (cursor < arr.length - 1) {
            arr[++cursor] = x;
            inc[cursor] = 0;
        }
    }

    public int pop() {
        if (cursor < 0)
            return -1;

        int x = arr[cursor];
        int i = inc[cursor--];

        if (cursor >= 0)
            inc[cursor] += i;

        return x + i;
    }

    public void increment(int k, int val) {
        if (cursor >= 0)
            inc[Math.min(k - 1, cursor)] += val;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int i = 0; i <= cursor; i++)
            sj.add("" + arr[i]);
        return sj.toString();
    }
}
