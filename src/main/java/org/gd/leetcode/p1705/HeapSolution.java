package org.gd.leetcode.p1705;

import java.util.PriorityQueue;

class HeapSolution implements Solution {

    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        int count = 0;
        PriorityQueue<Apple> heap = new PriorityQueue<>(n);
        for (int i = 0; i < n || !heap.isEmpty(); i++) {

            if (i < n) {
                int applesCount = apples[i];
                int daysToRot = days[i];
                if (applesCount > 0 && daysToRot > 0) {
                    heap.add(new Apple(i, i + daysToRot, applesCount));
                }
            }

            Apple apple;
            while (!heap.isEmpty() && ((apple = heap.peek()).rotDay <= i || apple.count <= 0)) {
                heap.poll();
            }

            if (!heap.isEmpty()) {
                count++;
                heap.peek().count--;
            }
        }


        return count;
    }

    static class Apple implements Comparable<Apple> {

        final int growDay;
        final int rotDay;
        int count;

        Apple(int growDay, int rotDay, int count) {
            this.growDay = growDay;
            this.rotDay = rotDay;
            this.count = count;
        }

        @Override
        public int compareTo(Apple o) {
            return Integer.compare(rotDay, o.rotDay);
        }
    }
}
