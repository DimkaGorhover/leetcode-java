package org.gd.leetcode.p0381;

import org.gd.leetcode.common.LeetCode;

import java.util.*;

/**
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0380.RandomizedSet
 * @since 2020-07-31
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Insert Delete GetRandom O(1) - Duplicates allowed",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.DESIGN
        }
)
class RandomizedCollection {

    private static final Value NULL = new Value(0);

    private final Map<Value, Value> positions;
    private final ArrayList<Value> list;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        positions = new HashMap<>();
        list = new ArrayList<>();
        list.add(NULL);
        size = 0;
    }

    private static int rnd(int bound) {
        return java.util.concurrent.ThreadLocalRandom.current().nextInt(0, bound);
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {

        Value value = new Value(val);
        if (positions.containsKey(value)) {

            value = positions.get(value);
            list.set(size, value);
            list.add(NULL);
            value.positions.add(size);

            size++;

            return false;
        }

        positions.put(value, value);
        list.set(size, value);
        list.add(NULL);
        value.positions.add(size);
        size++;

        return true;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {

        throw new UnsupportedOperationException(new String(new char[]{ 175, 92, 95, 40, 12_484, 41, 95, 47, 175 }));

//        Queue<Integer> queue = positions.get(val);
//        if (queue == null || queue.isEmpty())
//            return false;
//
//        int pos = queue.poll();
//
//
//        if (pos < size - 1) {
//            final int last = list.get(size - 1);
//            positions.put(last, pos);
//            list.set(pos, last);
//        }
//
//        size--;
//        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        if (size == 0)
            throw new NoSuchElementException();

        if (size == 1)
            return list.get(0).value;

        return list.get(rnd(size)).value;
    }


    static class Value {

        final int value;
        final Queue<Integer> positions;

        Value(int value) {
            this.value = value;
            positions = new LinkedList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Value)) return false;
            return value == ((Value) o).value;
        }

        @Override
        public int hashCode() { return value; }
    }
}
