package org.gd.leetcode.p0437;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @since 2019-09-14
 */
@DisplayName("LeetCode #437: Path Sum III")
@Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(1, 2), 2, 1),
                Arguments.of(TreeNode.of(1, null, 2, null, 3, null, 4, null, 5), 3, 2),
                Arguments.of(TreeNode.of(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), 8, 3)
        );
    }

    @ParameterizedTest(name = "{displayName} #{index}")
    @MethodSource("args")
    @DisplayName("PathSum")
    void test_PathSum(TreeNode node, int sum, int expected) {
        assertEquals(
                expected,
                new Solution().pathSum(node, sum),
                () -> String.format("%nnode: %s%nsum : %d%n%n", node, sum));
    }
}