package org.gd.leetcode.p0168;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution}
 *
 * @see org.gd.leetcode.p0171.SolutionTest
 * @since 2019-10-03
 */
@SuppressWarnings("JavadocReference")
@Execution(ExecutionMode.CONCURRENT)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(52, "AZ"),
                arguments(1, "A"),
                arguments(2, "B"),
                arguments(3, "C"),
                arguments(26, "Z"),
                arguments(27, "AA"),
                arguments(28, "AB"),
                arguments(701, "ZY"),
                arguments(7011, "JIQ")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("ConvertToTitle")
    void test_ConvertToTitle(int n, String expected) throws Exception {
        assertEquals(expected, new Solution().convertToTitle(n));
        assertEquals(expected, Solution.recursive(n));
        assertEquals(expected, Solution.loop(n));
    }
}