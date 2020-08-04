package org.gd.leetcode.p0538;

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
 * @see org.gd.leetcode.p1038.SolutionTest
 * @since 2020-08-04
 */
@SuppressWarnings({"deprecation", "JavadocReference"})
@DisplayName("LeetCode #538: Convert BST to Greater Tree")
@Timeout(value = 20, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(
                        TreeNode.of(5, 2, 13),
                        TreeNode.of(18, 20, 13)),

                Arguments.of(
                        TreeNode.of(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8),
                        TreeNode.of(30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8))

        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("ConvertBST")
    void test_ConvertBST(TreeNode root, TreeNode expected) {
        assertEquals(expected.copy(), new Solution().convertBST(root.copy()));
    }
}