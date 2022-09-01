package org.gd.leetcode.p0102;

import lombok.var;
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
 * @author Horkhover D.
 * @since 2020-07-03
 */
@DisplayName("LeetCode #102: Binary Tree Level Order Traversal")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        TreeNode.of(3, 9, 20, null, null, 15, 7),
                        java.util.Arrays.asList(
                                java.util.Arrays.asList(3),
                                java.util.Arrays.asList(9, 20),
                                java.util.Arrays.asList(15, 7)
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LevelOrder")
    void test_LevelOrder(TreeNode root, List<List<Integer>> expected) {
        var actual = new Solution().levelOrder(root);
        assertEquals(expected, actual);
    }
}