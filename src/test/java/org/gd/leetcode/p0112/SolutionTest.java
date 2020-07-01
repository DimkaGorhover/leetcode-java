package org.gd.leetcode.p0112;

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
class SolutionTest {

    private static Stream<Arguments> args() {

        TreeNode root0 = TreeNode.builder().val(5)
                .left(TreeNode.builder().val(4)
                        .left(TreeNode.builder().val(11)
                                .left(7)
                                .right(2)))
                .right(TreeNode.builder().val(8)
                        .left(13)
                        .right(TreeNode.builder().val(4)
                                .right(1)))
                .build();


        return Stream.of(
                Arguments.of(TreeNode.of(1, 2), 1, false),
                Arguments.of(root0, 22, true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #112: Path Sum")
    void hasPathSum(TreeNode root, int target, boolean expected) {
        assertEquals(expected, new Solution().hasPathSum(root, target));
    }
}