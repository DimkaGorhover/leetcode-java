package org.gd.leetcode.p0146;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: {@link #get(int)} and {@link #put(int, int)}.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up: Could you do both operations in O(1) time complexity?
 *
 * @since 2019-09-18
 */
@LeetCode(
        name = "LRU Cache",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.DESIGN)
class LRUCache {

    private final LRUCacheProvider provider;

    public LRUCache(int capacity) {
        provider = LRUCacheProvider.ofCapacity(capacity);
    }

    /**
     * @return the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     */
    public int get(int key) { return provider.get(key); }

    /**
     * Set or insert the value if the key is not already present. When the cache reached its capacity, it should
     * invalidate the least recently used item before inserting a new item.
     */
    public void put(int key, int value) { provider.put(key, value); }

    interface LRUCacheProvider {

        static LRUCacheProvider ofCapacity(int capacity) {
            if (capacity <= 0)
                return EmptyLRUCacheProvider.INSTANCE;

            if (capacity == 1)
                return new SingleValueLRUCacheProvider();

            return new Log_N_LRUCacheProvider(capacity);
        }

        int get(int key);

        void put(int key, int value);
    }

    static class EmptyLRUCacheProvider implements LRUCacheProvider {

        static final EmptyLRUCacheProvider INSTANCE = new EmptyLRUCacheProvider();

        private EmptyLRUCacheProvider() {}

        @Override
        public int get(int key) { return -1; }

        @Override
        public void put(int key, int value) {}
    }

    static class SingleValueLRUCacheProvider implements LRUCacheProvider {

        private int key, value;
        private boolean init = false;

        @Override
        public int get(int key) {
            return init && key == this.key ? value : -1;
        }

        @Override
        public void put(int key, int value) {
            this.key = key;
            this.value = value;
            init = true;
        }
    }

    static class Log_N_LRUCacheProvider implements LRUCacheProvider {

        private final Map<Integer, Node> map;
        private final ArrayList<Node> queue;

        int capacity;

        Log_N_LRUCacheProvider(int capacity) {
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

    static class Log_1_LRUCacheProvider implements LRUCacheProvider {

        @Override
        public int get(int key) {
            throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
        }

        @Override
        public void put(int key, int value) {
            throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
        }
    }
}
