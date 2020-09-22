package org.gd.leetcode.p0572;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 */
@DisplayName("LeetCode #572: Subtree of Another Tree")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(
                        TreeNode.of(3, 4, 5, 1, 2, null, null, 0),
                        TreeNode.of(4, 1, 2),
                        false),

                Arguments.of(
                        TreeNode.of(3, 4, 5, 1, 2),
                        TreeNode.of(4, 1, 2),
                        true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void isSubtree(TreeNode s, TreeNode t, boolean expected) {
        assertEquals(expected, new Solution().isSubtree(s, t));
    }
}
