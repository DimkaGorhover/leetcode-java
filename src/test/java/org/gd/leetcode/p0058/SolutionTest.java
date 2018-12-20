package org.gd.leetcode.p0058;

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
 * @since 2018-12-19
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments("Hello World", 5),
                arguments("a ", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LengthOfLastWord")
    void test_LengthOfLastWord(String input, int expected) {
        assertEquals(expected, new Solution().lengthOfLastWord(input));
    }
}