package org.gd.leetcode.p0226;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution}
 *
 * @since 2019-09-22
 */
@DisplayName("LeetCode #226: Invert Binary Tree")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(
                        TreeNode.of(4, 2, 7, 1, 3, 6, 9),
                        TreeNode.of(4, 7, 2, 9, 6, 3, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("InvertTree")
    void test_InvertTree(TreeNode root, TreeNode expected) {
        assertEquals(expected, new Solution().invertTree(root));
    }
}