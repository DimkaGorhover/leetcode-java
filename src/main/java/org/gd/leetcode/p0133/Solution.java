package org.gd.leetcode.p0133;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/clone-graph/
 */
@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DEPTH_FIRST_SEARCH,
                LeetCode.Tags.BREADTH_FIRST_SEARCH,
                LeetCode.Tags.GRAPH
        }
)
class Solution {

    private final Map<Integer, Node> visited = new HashMap<>();

    private Node clone0(Node node) {
        Node newNode = visited.get(node.val);
        if (newNode != null)
            return newNode;

        visited.put(node.val, newNode = new Node(node.val, new ArrayList<>(node.neighbors.size())));
        for (Node neighbor : node.neighbors)
            newNode.neighbors.add(cloneGraph(neighbor));

        return newNode;
    }

    public Node cloneGraph(Node node) {
        return node == null ? null : clone0(node);
    }
}
