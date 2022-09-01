package org.gd.leetcode.p0257;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.gd.leetcode.common.CollectionUtils.setOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 */
@DisplayName("LeetCode #257: Binary Tree Paths")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        TreeNode.of(1, 2, 3, null, 5),
                        setOf(
                                "1->2->5",
                                "1->3"
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void binaryTreePaths(TreeNode root, Set<String> expected) {
        assertEquals(
                new HashSet<>(expected),
                new HashSet<>(new Solution().binaryTreePaths(root))
        );
    }
}