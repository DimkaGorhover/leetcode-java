package org.gd.leetcode.p0863;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-09-06
 */
@DisplayName("LeetCode #863: All Nodes Distance K in Binary Tree")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(
                        TreeNode.of(0, 1, null, null, 2, null, 3, null, 4),
                        TreeNode.of(3),
                        0,
                        Set.of(3)),

                Arguments.of(
                        TreeNode.of(0, 2, 1, null, null, 3),
                        TreeNode.of(3),
                        3,
                        Set.of(2)),

                Arguments.of(
                        TreeNode.of(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4),
                        TreeNode.of(5),
                        2,
                        Set.of(7, 4, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("DistanceK")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_DistanceK(TreeNode root, TreeNode target, int K, Set<Integer> expected) {
        List<Integer> actual = new Solution().distanceK(root, target, K);
        assertEquals(expected, Set.copyOf(actual));
    }
}
