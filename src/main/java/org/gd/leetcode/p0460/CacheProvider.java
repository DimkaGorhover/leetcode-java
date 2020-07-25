package org.gd.leetcode.p0460;

interface CacheProvider {

    static CacheProvider ofCapacity(int capacity) {
        if (capacity == 0) {
            return ZeroCapacityCacheProvider.INSTANCE;
        }
        if (capacity == 1) {
            return new OneElementCacheProvider();
        }
        return new DefaultCacheProvider(capacity);
    }

    static CacheProvider logged(CacheProvider provider) {
        if (provider instanceof LoggedCacheProvider)
            return provider;
        return new LoggedCacheProvider(provider);
    }

    int get(int key);

    void put(int key, int value);
}
