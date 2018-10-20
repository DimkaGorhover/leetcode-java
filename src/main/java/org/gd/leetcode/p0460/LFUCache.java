package org.gd.leetcode.p0460;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lfu-cache/description/
 *
 * @author Gorkhover D.
 * @since 2018-10-17
 */
public class LFUCache {

    private final Map<Integer, CacheValue> storage;

    private CacheValue first = null, last = null;

    public LFUCache(int capacity) {
        storage = new HashMap<>(capacity);
    }

    public int get(int key) {
        CacheValue cv = storage.get(key);
        if (cv == null)
            return -1;

        cv.moveToHead();

        return cv.value();
    }

    public void put(int key, int value) {
        final CacheValue cv = new CacheValue(value);
        storage.put(key, cv);
        cv.moveToHead();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("LFUCache{");
        sb.append("queue=[");
        CacheValue cv = this.first;
        /*if (cv != null) {
            sb.append(cv.shortInfo());
            cv = cv.right;
            while (cv != null) {
                sb.append(", ").append(cv.shortInfo());
                cv = cv.right;
            }
        }*/
        return sb.append("]}").toString();
    }

    class CacheValue {

        final int value;

        int count = 1;

        CacheValue left = null, right = null;

        CacheValue(int value) { this.value = value; }

        void moveToHead() {
            if (first == this) {
                return;
            }
            if (first == null) {
                first = this;
                last = this;
                return;
            }
            if (last == this) {
                last = this.left;
            }
            this.right = first;
            first.left = this;
            first = this;
        }


        int value() {
            return value;
        }

        String shortInfo() {
            return String.format("{%d:%d}", value, count);
        }

        @Override
        public String toString() {
            return "{" +
                    "value=" + value +
                    ", count=" + count +
                    (left == null ? "" : (", left=" + left)) +
                    (right == null ? "" : (", right=" + right)) +
                    '}';
        }
    }
}
