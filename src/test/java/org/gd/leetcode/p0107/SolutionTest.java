package org.gd.leetcode.p0107;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-12-12
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(
                        TreeNode.of(3, 9, 20, null, null, 15, 7),
                        java.util.Arrays.asList(
                                java.util.Arrays.asList(15, 7),
                                java.util.Arrays.asList(9, 20),
                                java.util.Arrays.asList(3)
                        )),
                arguments(
                        TreeNode.of(1, 2, 3, 4, null, null, 5),
                        java.util.Arrays.asList(
                                java.util.Arrays.asList(4, 5),
                                java.util.Arrays.asList(2, 3),
                                java.util.Arrays.asList(1)
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LevelOrderBottom")
    void test_LevelOrderBottom(TreeNode root, List<List<Integer>> expected) {
        assertEquals(
                expected,
                new Solution().levelOrderBottom(root)
        );
    }
}