package org.gd.leetcode.p0541;

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
 * @author Horkhover D.
 * @since 2020-07-14
 */
@DisplayName("LeetCode #541: Reverse String II")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("abcdefg", 2, "bacdfeg")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("ReverseStr")
    void test_ReverseStr(String s, int k, String expected) {
        assertEquals(expected, new Solution().reverseStr(s, k));
    }
}