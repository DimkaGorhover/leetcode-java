package org.gd.leetcode.p0168;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**+
 * Test for {@link Solution}
 *
 * @see org.gd.leetcode.p0171.SolutionTest
 * @since 2019-10-03
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #168: Excel Sheet Column Title")
@Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(52, "AZ"),
                Arguments.of(1, "A"),
                Arguments.of(2, "B"),
                Arguments.of(3, "C"),
                Arguments.of(26, "Z"),
                Arguments.of(27, "AA"),
                Arguments.of(28, "AB"),
                Arguments.of(701, "ZY"),
                Arguments.of(7011, "JIQ")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Recursive")
    void test_Recursive(int n, String expected) {
        assertEquals(expected, new RecursiveSolution().convertToTitle(n));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Loop")
    void test_Loop(int n, String expected) {
        assertEquals(expected, new LoopSolution().convertToTitle(n));
    }
}
