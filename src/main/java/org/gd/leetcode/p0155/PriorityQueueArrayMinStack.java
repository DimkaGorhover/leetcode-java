package org.gd.leetcode.p0155;

import java.util.PriorityQueue;
import java.util.Queue;

@Deprecated
class PriorityQueueArrayMinStack implements MinStack {

    private final Queue<Integer> minQ;
    private int[] data;
    private int size;

    /** initialize your data structure here. */
    public PriorityQueueArrayMinStack() {
        data = new int[1 << 4];
        size = 0;
        minQ = new PriorityQueue<>();
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
        if (data[size - 1] == minQ.element())
            minQ.poll();
        size--;
    }

    public int top() { return data[size - 1]; }

    public int getMin() { return minQ.element(); }
}
