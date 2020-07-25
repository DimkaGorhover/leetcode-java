package org.gd.leetcode.p0146;

import org.gd.leetcode.common.LeetCode;

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
 * @see org.gd.leetcode.p0460.LFUCache
 * @since 2019-09-18
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "LRU Cache",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DESIGN,
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.LINKED_LIST
        })
class LRUCache {

    private final CacheProvider provider;

    public LRUCache(int capacity) {
        provider = CacheProvider.ofCapacity(capacity);
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
}
