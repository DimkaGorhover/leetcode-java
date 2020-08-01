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
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.DESIGN
        }
)
class RandomizedCollection {

    private final Map<Integer, Set<Integer>> positions;
    private final ArrayList<Integer> list;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {

        positions = new HashMap<>();

        list = new ArrayList<>();
        list.add(0);
        size = 0;
    }

    private static int rnd(int bound) {
        return java.util.concurrent.ThreadLocalRandom.current().nextInt(0, bound);
    }

    private int addToList(int val) {
        if (list.size() == size + 1)
            list.add(0);

        int pos = this.size;
        list.set(pos, val);
        this.size++;
        return pos;
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {

        Set<Integer> valuePositions = positions.get(val);
        if (valuePositions != null) {
            valuePositions.add(addToList(val));
            return false;
        }

        positions.put(val, valuePositions = new LinkedHashSet<>());
        valuePositions.add(addToList(val));

        return true;
    }

    private int pollPosition(Set<Integer> positions) {
        Iterator<Integer> iterator = positions.iterator();
        Integer next = iterator.next();
        iterator.remove();
        return next;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {

        if (size == 0)
            return false;

        Set<Integer> valuePositions = positions.get(val);
        if (valuePositions == null)
            return false;

        int pos = pollPosition(valuePositions);
        int lastPos = size - 1;
        if (pos < lastPos) {
            int latValue = list.get(lastPos);
            Set<Integer> posSet = positions.get(latValue);
            posSet.remove(lastPos);
            posSet.add(pos);
            list.set(pos, latValue);
        }

        if (valuePositions.isEmpty())
            positions.remove(val);

        size--;
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        if (size == 0) throw new java.util.NoSuchElementException();
        if (size == 1) return list.get(0);
        return list.get(rnd(size));
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";

        StringBuilder sb = new StringBuilder()
                .append('[')
                .append(list.get(0));

        for (int i = 1; i < size; i++)
            sb.append(',').append(' ').append(list.get(i));

        return sb.append(']').toString();
    }
}
