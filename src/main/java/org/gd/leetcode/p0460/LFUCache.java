package org.gd.leetcode.p0460;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO: https://leetcode.com/problems/lfu-cache/
 *
 * @author Gorkhover D.
 * @see org.gd.leetcode.p0146.LRUCache
 * @since 2018-10-17
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "LFU Cache",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.TODO,
        tags = LeetCode.Tags.DESIGN
)
class LFUCache {

    private final LFUCacheProvider provider;

    public LFUCache(int capacity) {
        provider = LFUCacheProvider.logged(LFUCacheProvider.ofCapacity(capacity));
    }

    public int get(int key) {
        return provider.get(key);
    }

    public void put(int key, int value) {
        provider.put(key, value);
    }

    interface LFUCacheProvider {

        static LFUCacheProvider ofCapacity(int capacity) {
            if (capacity == 0) {
                return ZeroCapacityLFUCacheProvider.INSTANCE;
            }
            if (capacity == 1) {
                return new OneElementLFUCacheProvider();
            }
            return new DefaultLFUCacheProvider(capacity);
        }

        static LFUCacheProvider logged(LFUCacheProvider provider) {
            if (provider instanceof LoggedLFUCacheProvider)
                return provider;
            return new LoggedLFUCacheProvider(provider);
        }

        int get(int key);

        void put(int key, int value);
    }

    static class LoggedLFUCacheProvider implements LFUCacheProvider {

        private final LFUCacheProvider provider;

        LoggedLFUCacheProvider(LFUCacheProvider provider) {
            this.provider = provider;
        }

        @Override
        public int get(int key) {

            int value = provider.get(key);

            System.out.println();
            System.out.printf("[%s]: get: %d --> %d%n", provider.getClass().getSimpleName(), key, value);

            return value;
        }

        @Override
        public void put(int key, int value) {

            System.out.println();
            System.out.printf("[%s]: put: %d --> %d%n", provider.getClass().getSimpleName(), key, value);
            System.out.printf("[%s]: before: %s%n", provider.getClass().getSimpleName(), provider);

            provider.put(key, value);

            System.out.printf("[%s]: after: %s%n", provider.getClass().getSimpleName(), provider);
        }

    }

    static class ZeroCapacityLFUCacheProvider implements LFUCacheProvider {

        static final ZeroCapacityLFUCacheProvider INSTANCE = new ZeroCapacityLFUCacheProvider();

        private ZeroCapacityLFUCacheProvider() {
        }

        @Override
        public int get(int key) {
            return -1;
        }

        @Override
        public void put(int key, int value) {
        }

        @Override
        public String toString() {
            return "ZeroCapacityLFUCacheProvider";
        }
    }

    static class OneElementLFUCacheProvider implements LFUCacheProvider {

        boolean init = false;
        int key, value;

        OneElementLFUCacheProvider() {
        }

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

        @Override
        public String toString() {
            return String.format("OneElementLFUCacheProvider[%s]",
                    (init ? (String.format("%d --> %d", key, value)) : ""));
        }
    }

    static class DefaultLFUCacheProvider implements LFUCacheProvider {

        private final ArrayList<CacheValue> queue;
        private final HashMap<Integer, CacheValue> storage;
        private final int capacity;

        DefaultLFUCacheProvider(int capacity) {
            this.capacity = capacity;
            storage = new HashMap<>(capacity);
            queue = new ArrayList<>(capacity);
        }

        @Override
        public int get(int key) {
            CacheValue value = storage.get(key);
            return value == null ? -1 : value.getValue();
        }

        @Override
        public void put(int key, int value) {

            CacheValue prev = storage.get(key);

            if (prev != null) {

                prev.setValue(value);

            } else {

                if (queue.size() == capacity) {
                    queue.sort(CacheValue.COMPARATOR);
                    prev = queue.remove(0);
                    storage.remove(prev.getKey());
                }

                CacheValue next = new CacheValue(key, value);
                queue.add(next);
                storage.put(key, next);
            }
        }

        @Override
        public String toString() {
            queue.sort(CacheValue.COMPARATOR);
            return "[queue=" + queue + ", storage=" + storage + "]";
        }
    }

    static class CacheValue implements Comparable<CacheValue> {

        static final Comparator<CacheValue> COMPARATOR = Comparator.nullsLast(CacheValue::compareTo);

        private static final AtomicLong INSTANCE_COUNTER = new AtomicLong(Long.MIN_VALUE);
        private static final AtomicLong USAGE_COUNTER = new AtomicLong(Long.MIN_VALUE);

        private final int key;

        private long instanceNumber;
        private long usageNumber;
        private int value;
        private long count = 0;

        CacheValue left = null, right = null;

        CacheValue(int key, int value) {
            this.key = key;
            setValue(value);
        }

        @Override
        public String toString() {
            return String.format("%d:%d:%d", key, value, count);
        }

        @Override
        public int compareTo(CacheValue o) {
            if (o == null)
                return -1;

            int compare = Long.compare(count, o.count);
            if (compare != 0)
                return compare;

            compare = Long.compare(usageNumber, o.usageNumber);
            if (compare != 0)
                return compare;

            return Long.compare(instanceNumber, o.instanceNumber);
        }

        public int getValue() {
            count++;
            usageNumber = USAGE_COUNTER.incrementAndGet();
            return value;
        }

        public void setValue(int value) {
            this.value = value;
            count = 0;
            instanceNumber = INSTANCE_COUNTER.incrementAndGet();
        }

        public int getKey() {
            return key;
        }
    }
}
