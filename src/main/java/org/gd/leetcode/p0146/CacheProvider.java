package org.gd.leetcode.p0146;

interface CacheProvider {

    static CacheProvider ofCapacity(int capacity) {
        if (capacity <= 0)
            return EmptyCacheProvider.INSTANCE;

        if (capacity == 1)
            return new SingleValueCacheProvider();

        return new O1CacheProvider(capacity);
    }

    int get(int key);

    void put(int key, int value);
}
