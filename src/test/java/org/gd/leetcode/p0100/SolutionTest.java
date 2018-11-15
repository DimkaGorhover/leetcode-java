package org.gd.leetcode.p0100;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-11-15
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(TreeNode.of(1, 2, 3), TreeNode.of(1, 2, 3), true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("IsSameTree")
    void test_IsSameTree(TreeNode p, TreeNode q, boolean expected) {

        SolutionAssertion sa = expected ? Assertions::assertTrue : Assertions::assertFalse;

        sa.doAssert(new Solution().isSameTree(p, q));
    }

    @FunctionalInterface
    interface SolutionAssertion {

        void doAssert(boolean res);
    }
}