package org.gd.leetcode.p1315;

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
 * @since 2020-09-22
 */
@DisplayName("LeetCode #1315: Nodes with Even-Valued Grandparent")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        TreeNode.of(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5),
                        18)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void sumEvenGrandparent(TreeNode root, int expected) {
        assertEquals(expected, new Solution().sumEvenGrandparent(root));
    }
}