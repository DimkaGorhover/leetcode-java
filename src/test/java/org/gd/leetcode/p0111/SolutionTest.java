package org.gd.leetcode.p0111;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2019-02-12
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.arguments(TreeNode.of(3, 9, 20, null, null, 15, 7), 2),
                Arguments.arguments(TreeNode.of(1, 2), 2),
                Arguments.arguments(null, 0),
                Arguments.arguments(TreeNode.of(1), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MinDepth")
    void test_MinDepth(TreeNode root, int expected) {
        assertEquals(expected, new Solution().minDepth(root));
    }
}