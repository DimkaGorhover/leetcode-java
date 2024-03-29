package org.gd.leetcode.p0530;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution}
 *
 * @since 2019-09-14
 */
@DisplayName("LeetCode #530: Minimum Absolute Difference in BST")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(TreeNode.of(1, null, 3, 2), 1),
                arguments(TreeNode.of(236, 104, 701, null, 227, null, 911), 9)
        );
    }

    @ParameterizedTest(name = "Minimum Absolute Difference in {0} is {1}")
    @MethodSource("args")
    @DisplayName("GetMinimumDifference")
    void test_GetMinimumDifference(TreeNode node, int expected) throws Exception {
        assertEquals(expected, new Solution().getMinimumDifference(node));
    }
}
