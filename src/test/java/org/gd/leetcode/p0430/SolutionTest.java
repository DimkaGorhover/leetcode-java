package org.gd.leetcode.p0430;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test for {@link Solution}
 */
@DisplayName("LeetCode #430: ")
class SolutionTest {

    @Test
    void flatten() {
        Node node =
                node(1)
                        .next(node(2)
                                .next(node(3)
                                        .child(node(7)
                                                .next(node(8)
                                                        .child(node(11)
                                                                .next(node(12).build())
                                                                .build())
                                                        .next(node(9)
                                                                .next(node(10).build())
                                                                .build())
                                                        .build())
                                                .build())
                                        .next(node(4)
                                                .next(node(5)
                                                        .next(node(6)
                                                                .build())
                                                        .build())
                                                .build())
                                        .build())
                                .build())
                        .build();

        Node expected = Node.of(1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6);
        Node actual = new Solution().flatten(node);

        assertEquals(expected, actual);

    }

    private static NodeBuilder node(int val) {
        return new NodeBuilder() {

            private Node prev;
            private Node next;
            private Node child;

            @Override
            public NodeBuilder prev(Node node) {
                prev = node;
                return this;
            }

            @Override
            public NodeBuilder next(Node node) {
                next = node;
                return this;
            }

            @Override
            public NodeBuilder child(Node node) {
                child = node;
                return this;
            }

            @Override
            public Node build() {
                Node node = new Node();
                node.val = val;
                node.prev = prev;
                node.next = next;
                node.child = child;
                return node;
            }
        };
    }

    interface NodeBuilder {

        NodeBuilder prev(Node node);

        NodeBuilder next(Node node);

        NodeBuilder child(Node node);

        Node build();
    }
}