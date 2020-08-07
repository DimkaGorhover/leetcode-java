package org.gd.leetcode.p0987;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-07
 */
@DisplayName("LeetCode #987: Vertical Order Traversal of a Binary Tree")
@Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(
                        TreeNode.of(0, 10, 1, null, null, 2, 4, 3, 5, null, null, 6, null, 7, 9, 8, null, null, null, null, 11, null, null, 12),
                        List.of(
                                List.of(8),
                                List.of(6),
                                List.of(10, 3),
                                List.of(0, 2, 7),
                                List.of(1, 5),
                                List.of(4, 9, 12),
                                List.of(11)
                        )),

                Arguments.of(
                        TreeNode.of(0, 5, 1, 9, null, 2, null, null, null, null, 3, 4, 8, 6, null, null, null, 7),
                        List.of(
                                List.of(9, 7),
                                List.of(5, 6),
                                List.of(0, 2, 4),
                                List.of(1, 3),
                                List.of(8)
                        )),

                Arguments.of(
                        TreeNode.of(0, 2, 1, 3, null, null, null, 4, 5, null, 7, 6, null, 10, 8, 11, 9),
                        List.of(
                                List.of(4, 10, 11),
                                List.of(3, 6, 7),
                                List.of(2, 5, 8, 9),
                                List.of(0),
                                List.of(1)
                        )),

                Arguments.of(
                        TreeNode.of(0, 8, 1, null, null, 3, 2, null, 4, 5, null, null, 7, 6),
                        List.of(
                                List.of(8),
                                List.of(0, 3, 6),
                                List.of(1, 4, 5),
                                List.of(2, 7)
                        )),

                Arguments.of(
                        TreeNode.of(1, 2, 3, 4, 5, 6, 7),
                        List.of(
                                List.of(4),
                                List.of(2),
                                List.of(1, 5, 6),
                                List.of(3),
                                List.of(7)
                        ))
        );
    }

    @ParameterizedTest(name = "{displayName} #{index}")
    @MethodSource("args")
    @DisplayName("VerticalTraversal")
    void test_VerticalTraversal(TreeNode root, List<List<Integer>> expected) {
        assertEquals(expected, new Solution().verticalTraversal(root));
    }
}