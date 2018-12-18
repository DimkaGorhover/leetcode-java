package org.gd.leetcode.p0101;

import org.gd.leetcode.common.BooleanAssertion;
import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-12-18
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(TreeNode.of(1, 2, 2, 3, 4, 4, 3), true),
                arguments(TreeNode.of(1, 2), false),
                arguments(TreeNode.of(1, 2, 3), false),
                arguments(TreeNode.of(1, 2, 2, null, 3, null, 3), false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("IsSymmetric")
    void test_IsSymmetric(TreeNode root, boolean symmetric) {
        BooleanAssertion.of(symmetric).doAssert(new Solution().isSymmetric(root));
    }
}