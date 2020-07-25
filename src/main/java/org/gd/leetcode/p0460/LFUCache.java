package org.gd.leetcode.p0460;

import org.gd.leetcode.common.LeetCode;

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
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DESIGN,
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.LINKED_LIST
        }
)
class LFUCache {

    private final CacheProvider cp;

    public LFUCache(int capacity) { cp = CacheProvider.ofCapacity(capacity); }

    public int get(int key) { return cp.get(key); }

    public void put(int key, int value) { cp.put(key, value); }

    @Override
    public String toString() { return cp.toString(); }
}
