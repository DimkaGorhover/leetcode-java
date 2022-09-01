package org.gd.leetcode.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link TreeNode}
 *
 * @author Horkhover D.
 * @since 2020-07-03
 */
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
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