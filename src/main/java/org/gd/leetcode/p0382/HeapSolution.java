package org.gd.leetcode.p0382;

import org.gd.leetcode.common.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Horkhover Dmytro
 * @see Solution
 * @since 2020-07-22
 */
@SuppressWarnings("ConstantConditions")
class HeapSolution {

    private final Queue<RandomValue> q;

    /**
     * @param head The linked list's head. Note that the head is guaranteed to be not null, so it contains at least one
     *             node.
     */
    public HeapSolution(ListNode head) {
        q = new PriorityQueue<>(length(head));
        while (head != null) {
            q.add(new RandomValue(head.val, Long.MIN_VALUE));
            head = head.next;
        }
    }

    private static int length(ListNode node) {
        if (node == null)
            return 0;
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
    public int getRandom() {
        RandomValue randomValue = q.poll();
        int value = randomValue.value;
        q.add(randomValue.next());
        return value;
    }

    static class RandomValue implements Comparable<RandomValue> {

        final int value;
        final long count;
        final double random;

        RandomValue(int value, long count) {
            this.value = value;
            this.count = count;
            this.random = ThreadLocalRandom.current().nextDouble();
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
