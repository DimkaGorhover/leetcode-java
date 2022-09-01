package org.gd.leetcode.p0145;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @see org.gd.leetcode.p0144.SolutionTest
 * @since 2018-10-23
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #145: Binary Tree Postorder Traversal")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(1, null, 2, 3), Arrays.asList(3, 2, 1)),
                Arguments.of(TreeNode.of(3, 1, 2), Arrays.asList(1, 2, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("PostorderTraversal")
    void test_PostorderTraversal(TreeNode input, List<Integer> expected) {
        assertEquals(expected, new Solution().postorderTraversal(input));
    }
}