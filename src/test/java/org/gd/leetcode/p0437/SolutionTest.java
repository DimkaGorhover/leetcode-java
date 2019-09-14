package org.gd.leetcode.p0437;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution}
 *
 * @since 2019-09-14
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(TreeNode.of(1, 2), 2, 1),
                arguments(TreeNode.of(1, null, 2, null, 3, null, 4, null, 5), 3, 2),
                arguments(TreeNode.of(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), 8, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("PathSum")
    void test_PathSum(TreeNode node, int sum, int expected) throws Exception {
        assertEquals(expected, new Solution().pathSum(node, sum), () -> {
            return String.format("%nnode: %s%nsum : %d%n%n", node, sum);
        });
    }
}