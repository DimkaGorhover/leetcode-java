package org.gd.leetcode.p1161;

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
 * @since 2019-09-23
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(TreeNode.of(1), 1),
                arguments(null, 0),
                arguments(TreeNode.of(1, 7, 0, 7, -8, null, null), 2),
                arguments(TreeNode.of(989, null, 10250, 98693, -89388, null, null, null, -32127), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MaxLevelSum")
    void test_MaxLevelSum(TreeNode root, int expected) throws Exception {
        assertEquals(expected, new Solution().maxLevelSum(root));
    }
}