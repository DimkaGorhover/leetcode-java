package org.gd.leetcode.p0460;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-25
 */
interface CacheProvider {

    static CacheProvider ofCapacity(int capacity) {
        if (capacity == 0)
            return ZeroCapacityCacheProvider.INSTANCE;

        if (capacity == 1)
            return new OneElementCacheProvider();

        return new O1CacheProvider(capacity);
    }

    int get(int key);

    void put(int key, int value);
}
