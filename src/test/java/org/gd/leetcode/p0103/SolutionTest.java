package org.gd.leetcode.p0103;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
                        java.util.Arrays.asList(
                                java.util.Arrays.asList(1),
                                java.util.Arrays.asList(3, 2),
                                java.util.Arrays.asList(4, 5, 6, 7)
                        )),
                Arguments.of(
                        TreeNode.of(1, 2, 3, 4, null, null, 5),
                        java.util.Arrays.asList(
                                java.util.Arrays.asList(1),
                                java.util.Arrays.asList(3, 2),
                                java.util.Arrays.asList(4, 5)
                        )),
                Arguments.of(
                        TreeNode.of(3, 9, 20, null, null, 15, 7),
                        java.util.Arrays.asList(
                                java.util.Arrays.asList(3),
                                java.util.Arrays.asList(20, 9),
                                java.util.Arrays.asList(15, 7)
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