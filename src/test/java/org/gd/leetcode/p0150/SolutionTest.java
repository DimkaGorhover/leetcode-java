package org.gd.leetcode.p0150;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.util.Arrays.copyOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-01
 */
@DisplayName("LeetCode #150: Evaluate Reverse Polish Notation")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new String[]{"2", "1", "+", "3", "*"}, 9),
                Arguments.of(new String[]{"3", "-4", "+"}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("EvalRPN")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_EvalRPN(String[] tokens, int expected) {
        assertEquals(expected, new Solution().evalRPN(copyOf(tokens, tokens.length)));
    }
}
