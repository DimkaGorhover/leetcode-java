package org.gd.leetcode.p1305;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-07
 */
@Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
@DisplayName("LeetCode #1305: All Elements in Two Binary Search Trees")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(
                        TreeNode.of(0, -10, 10),
                        TreeNode.of(5, 1, 7, 0, 2),
                        List.of(-10, 0, 0, 1, 2, 5, 7, 10)),

                Arguments.of(
                        TreeNode.of(2, 1, 4),
                        TreeNode.of(1, 0, 3),
                        List.of(0, 1, 1, 2, 3, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("GetAllElements")
    void test_GetAllElements(TreeNode root1, TreeNode root2, List<Integer> expected) {
        assertEquals(expected, new Solution().getAllElements(root1, root2));
    }
}