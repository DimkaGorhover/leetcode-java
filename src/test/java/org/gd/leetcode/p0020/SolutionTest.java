package org.gd.leetcode.p0020;

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
 * @since 2018-12-29
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("()[]{", false),
                Arguments.of("{[]}", true),
                Arguments.of("([)]", false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("IsValid")
    void test_IsValid(String s, boolean expected) {
        assertEquals(expected, new Solution().isValid(s));
    }
}