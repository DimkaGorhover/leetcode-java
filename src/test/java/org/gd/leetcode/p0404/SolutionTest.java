package org.gd.leetcode.p0404;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-24
 */
@DisplayName("LeetCode #404: Sum of Left Leaves")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(3), 0),
                Arguments.of(TreeNode.of(3, 9, 20, null, null, 15, 7), 24)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SumOfLeftLeaves")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_SumOfLeftLeaves(TreeNode root, int expected) {
        assertEquals(expected, new Solution().sumOfLeftLeaves(root));
    }
}
