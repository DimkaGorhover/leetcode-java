package org.gd.leetcode.p0284;

import org.gd.leetcode.common.LeetCode;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * https://leetcode.com/problems/peeking-iterator/
 *
 * @since 2019-09-13
 */
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = {LeetCode.Tags.DESIGN})
class PeekingIterator<T> implements Iterator<T> {

    private final Iterator<T> iterator;

    private T next = null;

    public PeekingIterator(Iterator<T> iterator) {
        this.iterator = iterator == null ? Collections.emptyIterator() : iterator;
    }

    /**
     * @return the next element in the iteration without advancing the iterator.
     */
    public T peek() {
        if (!hasNext())
            throw new NoSuchElementException();

        if (next != null)
            return next;

        return next = iterator.next();
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();

        if (next != null) {
            T next = this.next;
            this.next = null;
            return next;
        }

        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return next != null || iterator.hasNext();
    }
}
