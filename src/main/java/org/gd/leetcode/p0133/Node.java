package org.gd.leetcode.p0133;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;

    Node() {
        this(0);
    }

    Node(int val) {
        this(val, new ArrayList<>());
    }

    Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}
