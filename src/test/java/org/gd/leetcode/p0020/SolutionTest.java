package org.gd.leetcode.p0020;

import org.gd.leetcode.common.BooleanAssertion;
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
 * @since 2018-12-29
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments("()[]{", false),
                arguments("{[]}", true),
                arguments("([)]", false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("IsValid")
    void test_IsValid(String s, boolean expected) {
        BooleanAssertion.of(expected).doAssert(new Solution().isValid(s));
    }
}