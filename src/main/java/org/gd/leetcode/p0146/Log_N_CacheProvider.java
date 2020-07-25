package org.gd.leetcode.p0146;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Log_N_CacheProvider implements CacheProvider {

    private final Map<Integer, Node> map;
    private final ArrayList<Node> queue;

    int capacity;

    Log_N_CacheProvider(int capacity) {
        map = new HashMap<>(this.capacity = capacity);
        queue = new ArrayList<>(capacity);
    }

    @Override
    public int get(int key) {
        Node node = map.get(key);
        return node == null ? -1 : node.getValue();
    }

    @Override
    public void put(int key, int value) {

        if (map.containsKey(key)) {
            map.get(key).setValue(value);
        } else {

            if (queue.size() == capacity) {
                queue.sort(Node.COMPARATOR);
                Node prev = queue.remove(0);
                map.remove(prev.getKey());
            }

            Node next = new Node(key, value);
            queue.add(next);
            map.put(key, next);

        }
    }

    static class Node implements Comparable<Node> {

        static final Comparator<? super Node> COMPARATOR = Comparator.nullsLast(Node::compareTo);

        private static final java.util.concurrent.atomic.AtomicLong USAGE = new java.util.concurrent.atomic.AtomicLong(Long.MIN_VALUE);

        private final int key;

        private int value;
        private long usage;

        Node(int key, int value) {
            this.key = key;
            setValue(value);
        }

        public int getKey() { return key; }

        public int getValue() {
            usage = USAGE.accumulateAndGet(1, Math::addExact);
            return value;
        }

        public void setValue(int value) {
            this.value = value;
            getValue();
        }

        @Override
        public int compareTo(Node node) {
            if (node == null)
                return -1;

            return Long.compare(usage, node.usage);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", instance=" + usage +
                    '}';
        }
    }
}
