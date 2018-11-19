package org.gd.leetcode.p0617;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-11-18
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(
                        TreeNode.of(1, 3, 2, 5),
                        TreeNode.of(2, 1, 3, null, 4, null, 7),
                        TreeNode.of(3, 4, 5, 5, 4, null, 7)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MergeTrees")
    void test_MergeTrees(TreeNode t1, TreeNode t2, TreeNode expected) {
        assertEquals(
                expected,
                new Solution().mergeTrees(t1, t2)
        );
    }
}