package org.gd.leetcode.p1022;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 */
@DisplayName("LeetCode #1022: Sum of Root To Leaf Binary Numbers")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(1, 0, 1, 0, 1, 0, 1), 22)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #1022: Sum of Root To Leaf Binary Numbers")
    void sumRootToLeaf(TreeNode root, int expected) {
        int actual = new Solution().sumRootToLeaf(root);
        assertEquals(expected, actual);
    }
}