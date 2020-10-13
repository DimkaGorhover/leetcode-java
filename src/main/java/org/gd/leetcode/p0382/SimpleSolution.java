package org.gd.leetcode.p0382;

import org.gd.leetcode.common.ListNode;

import java.util.Random;

/**
 * @see HeapSolution
 * @since 2020-07-22
 */
@SuppressWarnings("deprecation")
class SimpleSolution implements Solution {

    private final Delegate delegate;

    public SimpleSolution(ListNode head) {
        if (head == null)
            throw new NullPointerException();

        delegate = Delegate.of(head);
    }

    private static int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    @Override
    public int getRandom() {
        return delegate.getRandom();
    }

    interface Delegate {

        static Delegate of(ListNode head) {

            final int length = length(head);
            if (length < ArrayDelegate.THRESHOLD)
                return new ArrayDelegate(head, length);

            return new LinkedListDelegate(head);
        }

        int getRandom();
    }

    static class ArrayDelegate implements Delegate {

        static final int THRESHOLD = 1 << 13;

        private final int[] array;
        private final int length;
        private final Random random;

        ArrayDelegate(ListNode head, int length) {
            this.random = new Random();
            this.length = length;
            array = new int[nextPowerOf2(length)];

            for (int i = 0; head != null; i++) {
                array[i] = head.val;
                head = head.next;
            }
        }

        public static int nextPowerOf2(long n) {
            n--;
            n |= n >> 1;
            n |= n >> 2;
            n |= n >> 4;
            n |= n >> 8;
            n |= n >> 16;
            return Math.toIntExact(n + 1);
        }

        @Override
        public int getRandom() {
            int result = 0;
            for (int n = 1, i = 0; i < length; n++) {

                if (random.nextInt(n) == 0)
                    result = array[i];

                i++;
            }
            return result;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName();
        }
    }

    static class LinkedListDelegate implements Delegate {

        private final ListNode head;
        private final Random random;

        LinkedListDelegate(ListNode head) {
            if (head == null)
                throw new NullPointerException();
            this.head = head;
            this.random = new Random();
        }

        @Override
        public int getRandom() {
            ListNode result = null;
            ListNode current = head;
            for (int n = 1; current != null; n++) {

                if (random.nextInt(n) == 0)
                    result = current;

                current = current.next;
            }
            return result.val;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName();
        }
    }

    @Override
    public String toString() {
        return "SimpleSolution{" +
                "delegate=" + delegate +
                '}';
    }
}
