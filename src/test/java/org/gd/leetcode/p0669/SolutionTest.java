package org.gd.leetcode.p0669;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution}
 *
 * @since 2019-10-03
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(TreeNode.of(1, 0, 2), 1, 2, TreeNode.of(1, null, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("TrimBST")
    void test_TrimBST(TreeNode node, int L, int R, TreeNode expected) throws Exception {
        assertEquals(expected, new Solution().trimBST(node, L, R));
    }
}