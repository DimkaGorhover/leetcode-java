package org.gd.leetcode.p0958;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-09-21
 */
@DisplayName("LeetCode #958: Check Completeness of a Binary Tree")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(1, 2, 3, 4, 5, 6), true),
                Arguments.of(TreeNode.of(1, 2, 3, 4, 5, null, 7, 8), false),
                Arguments.of(TreeNode.of(1, 2, 3, 5, null, 7, 8), false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void isCompleteTree(TreeNode root, boolean expected) {
        assertEquals(expected, new Solution().isCompleteTree(root));
    }
}
