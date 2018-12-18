package org.gd.leetcode.p0145;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @see org.gd.leetcode.p0144.SolutionTest
 * @since 2018-10-23
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(TreeNode.of(1, null, 2, 3), List.of(3, 2, 1)),
                arguments(TreeNode.of(3, 1, 2), List.of(1, 2, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("PostorderTraversal")
    void test_PostorderTraversal(TreeNode input, List<Integer> expected) {
        assertEquals(expected, new Solution().postorderTraversal(input));
    }
}