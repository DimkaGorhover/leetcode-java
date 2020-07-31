package org.gd.leetcode.p0380;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0381.RandomizedCollection
 * @since 2020-07-31
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Insert Delete GetRandom O(1)",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.DESIGN
        }
)
class RandomizedSet {

    private final Map<Integer, Integer> positions;
    private final ArrayList<Integer> list;
    private int size;

    private static int rnd(int bound) {
        return java.util.concurrent.ThreadLocalRandom.current().nextInt(0, bound);
    }

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        positions = new HashMap<>();
        list = new ArrayList<>();
        list.add(0);
        size = 0;
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {

        if (positions.containsKey(val))
            return false;

        positions.put(val, size);
        list.set(size, val);
        list.add(0);
        size++;

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        final Integer pos = positions.remove(val);
        if (pos == null)
            return false;

        if (pos < size - 1) {
            final int last = list.get(size - 1);
            positions.put(last, pos);
            list.set(pos, last);
        }

        size--;
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (size == 0)
            throw new RuntimeException("there is no elements in set");

        if (size == 1)
            return list.get(0);

        return list.get(rnd(size));
    }
}
