package org.gd.leetcode.p0264;

import java.util.PriorityQueue;
import java.util.Queue;

@SuppressWarnings("ConstantConditions")
class DPSolution implements Solution {

    public int nthUglyNumber(int n) {
        if (n < 1) return 0;
        if (n < 7) return n;

        int i = 1;
        int[] ints = new int[n];
        ints[0] = 1;

        Queue<Integer> q = new PriorityQueue<>();

        while (i < n) {
            q.add(ints[i - 1] * 2);
            q.add(ints[i - 1] * 3);
            q.add(ints[i - 1] * 5);

            int value = q.poll();

            if (ints[i - 1] != value)
                ints[i++] = value;
        }

        return ints[n - 1];
    }
}
