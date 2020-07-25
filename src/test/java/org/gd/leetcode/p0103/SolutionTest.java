package org.gd.leetcode.p0103;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-25
 */
@DisplayName("LeetCode #103: Binary Tree Zigzag Level Order Traversal")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        TreeNode.of(1, 2, 3, 4, 5, 6, 7),
                        List.of(
                                List.of(1),
                                List.of(3, 2),
                                List.of(4, 5, 6, 7)
                        )),
                Arguments.of(
                        TreeNode.of(1, 2, 3, 4, null, null, 5),
                        List.of(
                                List.of(1),
                                List.of(3, 2),
                                List.of(4, 5)
                        )),
                Arguments.of(
                        TreeNode.of(3, 9, 20, null, null, 15, 7),
                        List.of(
                                List.of(3),
                                List.of(20, 9),
                                List.of(15, 7)
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("ZigzagLevelOrder")
    void test_ZigzagLevelOrder(TreeNode root, List<List<Integer>> expected) {
        assertEquals(expected, new Solution().zigzagLevelOrder(root));
    }
}