package org.gd.leetcode.p2336;

/**
 * <a href="https://leetcode.com/problems/smallest-number-in-infinite-set/">LeetCode #2336: Smallest Number in Infinite
 * Set</a>
 *
 * @author Horkhover Dmytro
 * @since 2022-09-23
 */
class SmallestInfiniteSet {

    private final java.util.PriorityQueue<Integer> heap;
    private final boolean[] map;
    private int next;

    public SmallestInfiniteSet() {
        heap = new java.util.PriorityQueue<>();
        map = new boolean[1_001];
        next = 1;
    }

    public int popSmallest() {
        if (heap.size() > 0) {
            int value = heap.poll();
            map[value] = false;
            return value;
        }
        int next = this.next;
        this.next++;
        return next;
    }

    public void addBack(int num) {
        if (map[num] || num >= next) {
            return;
        }
        map[num] = true;
        heap.add(num);
    }
}
