package org.gd.leetcode.p0098;

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
 * @since 2018-11-15
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(TreeNode.of(2, 1, 3), true),
                arguments(TreeNode.of(5, 1, 4, null, null, 3, 6), false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("IsValidBST")
    void test_IsValidBST(TreeNode node, boolean expected) {

        BooleanAssertion.of(expected).doAssert(new Solution().isValidBST(node));
    }
}