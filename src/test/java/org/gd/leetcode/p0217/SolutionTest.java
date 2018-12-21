package org.gd.leetcode.p0217;

import org.gd.leetcode.common.BooleanAssertion;
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
 * @since 2018-12-21
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 1}, true),
                arguments(new int[]{1, 2, 3, 4}, false),
                arguments(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("ContainsDuplicate")
    void test_ContainsDuplicate(int[] input, boolean expected) {
        BooleanAssertion.of(expected).doAssert(new Solution().containsDuplicate(input));
    }
}