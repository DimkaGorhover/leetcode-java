package org.gd.leetcode.p0617;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-11-18
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                // TODO: add test cases
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