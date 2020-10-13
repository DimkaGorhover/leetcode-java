package org.gd.leetcode.p0382;

import org.gd.leetcode.common.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @author Horkhover Dmytro
 * @see SimpleSolution
 * @since 2020-07-22
 */
@Deprecated
@SuppressWarnings("ConstantConditions")
class HeapSolution implements Solution {

    private final Queue<RandomValue> heap;
    private final Random random;

    /**
     * @param head The linked list's head. Note that the head is guaranteed to be not null, so it contains at least one
     *             node.
     */
    public HeapSolution(ListNode head) {
        heap = new PriorityQueue<>(length(head));
        random = new Random();
        while (head != null) {
            heap.add(new RandomValue(head.val, Long.MIN_VALUE));
            head = head.next;
        }
    }

    private static int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * @return a random node's value.
     */
    @Override
    public int getRandom() {
        RandomValue randomValue = heap.poll();
        int value = randomValue.value;
        heap.add(randomValue.next());
        return value;
    }

    class RandomValue implements Comparable<RandomValue> {

        final int value;
        final long count;
        final double random;

        RandomValue(int value, long count) {
            this.value = value;
            this.count = count;
            this.random = HeapSolution.this.random.nextDouble();
        }

        RandomValue next() {
            return new RandomValue(value, count + 1);
        }

        @Override
        public int compareTo(RandomValue o) {
            int compare = Long.compare(count, o.count);
            if (compare != 0)
                return compare;

            return Double.compare(random, o.random);
        }
    }
}
