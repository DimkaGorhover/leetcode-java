package org.gd.leetcode.p0133;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("LeetCode #133: Clone Graph")
class SolutionTest {

    private static Map<Integer, Node> toMap(Node node) {
        Map<Integer, Node> set = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while ((node = q.poll()) != null) {
            if (!set.containsKey(node.val)) {
                set.put(node.val, node);
                q.addAll(node.neighbors);
            }
        }
        return set;
    }

    private static List<Arguments> args() {

        final Node node1 = new Node(1);
        final Node node2 = new Node(2);
        final Node node3 = new Node(3);
        final Node node4 = new Node(4);

        node1.neighbors.addAll(java.util.Arrays.asList(node2, node4));
        node2.neighbors.addAll(java.util.Arrays.asList(node1, node3));
        node3.neighbors.addAll(java.util.Arrays.asList(node4, node2));
        node4.neighbors.addAll(java.util.Arrays.asList(node1, node3));

        return java.util.Arrays.asList(
                Arguments.of(node1)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void cloneGraph(Node node1) {

        Node actualNode = new Solution().cloneGraph(node1);

        Map<Integer, Node> expected = toMap(node1);
        Map<Integer, Node> actual = toMap(actualNode);

        for (Node expectedNode : expected.values()) {

            assertTrue(actual.containsKey(expectedNode.val));

            assertNotNull(actualNode = actual.get(expectedNode.val));

            assertNotSame(expectedNode.neighbors, actualNode.neighbors);
            assertEquals(expectedNode.neighbors.size(), actualNode.neighbors.size());

            for (int i = 0; i < expectedNode.neighbors.size(); i++) {
                Node n1 = expectedNode.neighbors.get(i);
                Node n2 = actualNode.neighbors.get(i);
                assertNotSame(n1, n2);
                assertEquals(n1.val, n2.val);
            }

            // check if expected object doesn not exist in HashMap (hashCode == object address)
            assertFalse(actual.containsValue(expectedNode));

            // check if point to the object is not the same
            assertNotSame(expectedNode, actualNode);

            // check if values are equal
            assertEquals(expectedNode.val, actualNode.val);
        }
    }
}