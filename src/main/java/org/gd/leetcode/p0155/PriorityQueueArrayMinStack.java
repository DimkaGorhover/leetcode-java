package org.gd.leetcode.p0155;

import org.gd.leetcode.common.LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

class PriorityQueueArrayMinStack implements MinStack {

    private Queue<Integer> minQ = new PriorityQueue<>();
    private int[] data;
    private int size;

    /** initialize your data structure here. */
    public PriorityQueueArrayMinStack() {
        data = new int[1 << 4];
        size = 0;
    }

    public void push(int x) {
        if (size + 1 > data.length) {
            int[] newData = new int[data.length << 1];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size] = x;
        size++;
        minQ.offer(x);
    }

    public void pop() {
        int last = data[size - 1];
        if (last == minQ.peek())
            minQ.poll();
        size--;
    }

    public int top() {
        return data[size - 1];
    }

    public int getMin() {
        return minQ.peek();
    }
}
