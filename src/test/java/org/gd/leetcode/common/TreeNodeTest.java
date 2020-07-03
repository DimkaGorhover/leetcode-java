package org.gd.leetcode.common;

import org.junit.jupiter.api.*;

import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link TreeNode}
 *
 * @author Horkhover D.
 * @since 2020-07-03.07.2020
 */
class TreeNodeTest {

    @Test
    @DisplayName("Copy")
    void test_Copy() {
    }

    @SuppressWarnings("deprecation")
    @Test
    @DisplayName("Deep")
    void test_Deep() {
        TreeNode node = TreeNode.of(1, 2, 3, 4, 5, 6, 7);
        assertEquals(3, node.deep());
    }

    @SuppressWarnings("deprecation")
    @Test
    @DisplayName("Sum")
    void test_Sum() {
        TreeNode node = TreeNode.of(1, 2, 3, 4, 5, 6, 7);
        assertEquals(
                LongStream.rangeClosed(1, 7).sum(),
                node.sum());
    }
}