package org.gd.leetcode.p0949;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Horkhover Dmytro
 * @since 2020-09-01
 */
class Solution {

    private static String toString(int value) {
        return value > 10 ? "" + value : "0" + value;
    }

    public String largestTimeFromDigits(int[] A) {

        if (A == null || A.length != 4)
            return "";

        PriorityQueue<Integer> heap = new PriorityQueue<>(A.length, Comparator.reverseOrder());
        for (int i : A)
            heap.add(i);

        int minutes = heap.poll();
        minutes = heap.poll() * 10 + minutes;

        int hours = heap.poll();
        hours = heap.poll() * 10 + hours;

        if (minutes >= 60 || hours > 23)
            return "";

        return toString(hours) + ":" + toString(minutes);
    }
}
