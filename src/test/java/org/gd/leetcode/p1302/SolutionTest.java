package org.gd.leetcode.p1302;

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
 * @since 2020-08-12
 */
@DisplayName("LeetCode #1302: Deepest Leaves Sum")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5), 19),
                Arguments.of(TreeNode.of(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8), 15)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("DeepestLeavesSum")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_DeepestLeavesSum(TreeNode root, int expected) {
        assertEquals(expected, new Solution().deepestLeavesSum(root));
    }
}
