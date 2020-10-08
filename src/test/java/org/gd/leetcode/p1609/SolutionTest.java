package org.gd.leetcode.p1609;

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
 * @author Horkhover Dmytro
 * @since 2020-10-08
 */
@DisplayName("LeetCode #1609: Even Odd Tree")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(5, 4, 2, 3, 3, 7), false),
                Arguments.of(TreeNode.of(1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2), true),
                Arguments.of(TreeNode.of(11, 8, 6, 1, 3, 9, 11, 30, 20, 18, 16, 12, 10, 4, 2, 17), true),
                Arguments.of(TreeNode.of(1), true),
                Arguments.of(TreeNode.of(5, 9, 1, 3, 5, 7), false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("IsEvenOddTree")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_IsEvenOddTree(TreeNode root, boolean expected) {
        assertEquals(expected, new Solution().isEvenOddTree(root));
    }
}
