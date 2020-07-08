package org.gd.leetcode.p0341;

import org.gd.leetcode.common.LeetCode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 */
@LeetCode(
        name = "Flatten Nested List Iterator",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.STACK,
                LeetCode.Tags.DESIGN
        }
)
class NestedIterator implements Iterator<Integer> {

    private final Stack stack;

    private Integer next = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack();
        stack.push(nestedList.iterator());
    }

    @Override
    public boolean hasNext() {
        Iterator<NestedInteger> iterator;
        while (next == null) {
            if ((iterator = stack.pop()) == null)
                return false;
            if (!iterator.hasNext())
                continue;

            NestedInteger next = iterator.next();
            if (iterator.hasNext())
                stack.push(iterator);

            if (next.isInteger()) {
                this.next = next.getInteger();
            } else {
                stack.push(next.getList().iterator());
            }
        }
        return true;
    }

    @Override
    public Integer next() {

        if (next == null && !hasNext())
            throw new NoSuchElementException();

        Integer next = this.next;
        this.next = null;
        return next;
    }

    static class Stack {

        private final LinkedList<Iterator<NestedInteger>> s = new LinkedList<>();

        void push(Iterator<NestedInteger> iterator) {
            s.addFirst(iterator);
        }

        Iterator<NestedInteger> pop() {
            return s.pollFirst();
        }
    }
}
