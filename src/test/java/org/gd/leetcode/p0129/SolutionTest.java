package org.gd.leetcode.p0129;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-11-15
 */
@DisplayName("LeetCode #129: Sum Root to Leaf Numbers")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(TreeNode.of(1, 2, 3), 25),
                arguments(TreeNode.of(4, 9, 0, 5, 1), 1026)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SumNumbers")
    void test_SumNumbers(TreeNode node, int expected) {
        assertEquals(expected, new Solution().sumNumbers(node));
    }
}
