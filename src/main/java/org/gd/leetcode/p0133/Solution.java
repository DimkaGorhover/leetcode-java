package org.gd.leetcode.p0133;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/clone-graph/
 */
@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.DEPTH_FIRST_SEARCH,
                LeetCode.Tags.BREADTH_FIRST_SEARCH,
                LeetCode.Tags.GRAPH
        }
)
class Solution {

    private final Set<Integer> visited = new HashSet<>();

    public Node cloneGraph(Node node) {

        if (visited.contains(node.val))
            return node;

        Node newNode = new Node(node.val);
        newNode.neighbors.addAll(node.neighbors);

        for (Node neighbor : newNode.neighbors) {

            int position = neighbor.neighbors.indexOf(node);
            neighbor.neighbors.set(position, newNode);
            visited.add(newNode.val);
            cloneGraph(neighbor);
        }

        return newNode;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        Node() {
            this(0);
        }

        Node(int _val) {
            this(_val, new ArrayList<>());
        }

        Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }
}
