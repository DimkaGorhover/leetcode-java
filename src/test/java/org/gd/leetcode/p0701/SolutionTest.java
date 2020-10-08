package org.gd.leetcode.p0701;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-10-08
 */
@DisplayName("LeetCode #701: Insert into a Binary Search Tree")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(4, 2, 7, 1, 3), 5, Set.of(
                        TreeNode.of(4, 2, 7, 1, 3, 5),
                        TreeNode.of(5, 2, 7, 1, 3, null, null, null, null, null, 4)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("InsertIntoBST")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_InsertIntoBST(TreeNode root, int val, Set<TreeNode> expected) {

        TreeNode actual = new Solution().insertIntoBST(root, val);

        if (!expected.contains(actual)) {
            fail(actual::toString);
        }
    }
}
