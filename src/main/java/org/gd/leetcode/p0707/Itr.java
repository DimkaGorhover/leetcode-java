package org.gd.leetcode.p0707;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.util.Objects.requireNonNull;

class Itr implements Iterator<Integer> {

    private Node node;

    Itr(Node node) {
        requireNonNull(node, "\"node\" cannot be null");
        this.node = node;
    }

    @Override
    public boolean hasNext() { return node != null; }

    @Override
    public Integer next() {

        if (!hasNext())
            throw new NoSuchElementException();

        Node node = this.node;
        this.node = node.right;
        return node.value;
    }
}
