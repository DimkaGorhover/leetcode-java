package org.gd.leetcode.p0706;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/design-hashmap/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-02
 */
@LeetCode(
        name = "Design HashMap",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.DESIGN
        }
)
class MyHashMap {

    private final int[] arr;

    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new int[1_000_000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        arr[key] = value + 1;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return arr[key] - 1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        arr[key] = 0;
    }
}
