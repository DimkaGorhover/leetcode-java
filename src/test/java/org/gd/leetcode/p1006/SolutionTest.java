package org.gd.leetcode.p1006;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-31
 */
@DisplayName("LeetCode #1006: Clumsy Factorial")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(4, 7),
                Arguments.of(10, 12)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Math")
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    void test_Math(int n, int expected) {
        assertEquals(expected, new MathSolution().clumsy(n));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Loop")
    @Timeout(value = 20, unit = TimeUnit.MILLISECONDS)
    void test_Loop(int n, int expected) {
        assertEquals(expected, new LoopSolution().clumsy(n));
    }
}