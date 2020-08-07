package org.gd.leetcode.p0653;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-07
 */
@DisplayName("LeetCode #653: Two Sum IV - Input is a BST")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(2, 1, 3), 4, true),
                Arguments.of(TreeNode.of(5, 3, 6, 2, 4, null, 7), 9, true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("FindTarget")
    void test_FindTarget(TreeNode root, int k, boolean expected) {
        assertEquals(expected, new Solution().findTarget(root, k));
    }
}