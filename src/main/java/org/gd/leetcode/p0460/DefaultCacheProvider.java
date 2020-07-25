package org.gd.leetcode.p0460;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-25
 */
@Deprecated
class DefaultCacheProvider implements LFUCache.CacheProvider {

    private final ArrayList<CacheValue> queue;
    private final HashMap<Integer, CacheValue> storage;
    private final int capacity;

    DefaultCacheProvider(int capacity) {
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
