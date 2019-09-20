package org.gd.leetcode.p0146;

import org.gd.leetcode.common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Objects.requireNonNull;

/**
 * TODO: https://leetcode.com/problems/lru-cache/
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
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = LeetCode.Tags.DESIGN)
class LRUCache {

    private final Delegate delegate;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            delegate = EmptyDelegate.INSTANCE;
        } else if (capacity == 1) {
            delegate = SingleValueDelegate.INSTANCE;
        } else {
            delegate = new HashMapDelegate(capacity);
        }
    }

    /**
     * @return the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     */
    public int get(int key) { return delegate.get(key); }

    /**
     * Set or insert the value if the key is not already present. When the cache reached its capacity, it should
     * invalidate the least recently used item before inserting a new item.
     */
    public void put(int key, int value) { delegate.put(key, value); }

    interface Delegate {

        int get(int key);

        void put(int key, int value);
    }

    static class EmptyDelegate implements Delegate {

        static final EmptyDelegate INSTANCE = new EmptyDelegate();

        private EmptyDelegate() {}

        @Override
        public int get(int key) { return -1; }

        @Override
        public void put(int key, int value) {}
    }

    static class SingleValueDelegate implements Delegate {

        static final SingleValueDelegate INSTANCE = new SingleValueDelegate();

        private SingleValueDelegate() {}

        private int key, value;

        @Override
        public int get(int key) {
            return key == this.key ? value : -1;
        }

        @Override
        public void put(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class HashMapDelegate implements Delegate {

        private final Map<Integer, Node> map;
        private final Queue<Node> queue;

        int capacity;

        HashMapDelegate(int capacity) {
            map = new HashMap<>(this.capacity = capacity);
            queue = new PriorityQueue<>();
        }

        @Override
        public int get(int key) {
            Node node = map.get(key);
            return node == null ? -1 : node.getValue();
        }

        @Override
        public void put(int key, int value) {
            Node node = new Node(key, value);
            Node prev = map.put(key, node);
            if (capacity == 0) {
                Node poll = queue.poll();
                map.remove(poll.key);
            } else if (prev == null) {
                capacity--;
            }
            queue.add(node);
        }
    }

    static class Node implements Comparable<Node> {

        private final int key, value;
        private int count;

        Node(int value, int key) {
            this.key = key;
            this.value = value;
        }

        public int getValue() {
            count++;
            return value;
        }

        @Override
        public int compareTo(Node node) {
            requireNonNull(node, "\"node\" cannot be null");
            return Integer.compare(count, node.count);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return key == node.key &&
                    value == node.value;
        }

        @Override
        public int hashCode() {
            int result = key;
            result = 31 * result + value;
            return result;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", count=" + count +
                    '}';
        }
    }
}
