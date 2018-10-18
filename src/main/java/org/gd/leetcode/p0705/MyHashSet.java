package org.gd.leetcode.p0705;

/**
 * https://leetcode.com/problems/design-hashset/
 *
 * @author Gorkhover D.
 * @since 2018-10-18
 */
public class MyHashSet {

    private final boolean[] positive = new boolean[Short.MAX_VALUE * 2];
    private final boolean[] negative = new boolean[Short.MAX_VALUE * 2];

    private boolean zero = false;

    public MyHashSet() {

    }

    public void add(int key) {
        if (key == 0) {
            zero = true;
        } else if (key > 0) {
            positive[key] = true;
        } else {
            negative[-key] = true;
        }
    }

    public void remove(int key) {
        if (key == 0) {
            zero = false;
        } else if (key >= 0) {
            positive[key] = false;
        } else {
            positive[-key] = false;
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        if (key == 0)
            return zero;
        if (key > 0)
            return positive[key];
        return negative[-key];
    }
}
