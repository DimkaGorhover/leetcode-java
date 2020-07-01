package org.gd.leetcode.p0113;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @see org.gd.leetcode.p0112.SolutionTest
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
                                .left(5)
                                .right(1)))
                .build();


        List<List<Integer>> expected0 = List.of(
                List.of(5, 8, 4, 5),
                List.of(5, 4, 11, 2)
        );


        return Stream.of(
                Arguments.of(root0, 22, expected0)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #113: Path Sum II")
    void pathSum(TreeNode root, int target, List<List<Integer>> expected) {
        List<List<Integer>> actual = new Solution().pathSum(root, target);
        assertEquals(
                new HashSet<>(expected),
                new HashSet<>(actual)
        );
    }
}