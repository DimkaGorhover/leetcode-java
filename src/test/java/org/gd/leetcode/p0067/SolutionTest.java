package org.gd.leetcode.p0067;

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
 * @author Gorkhover D.
 * @since 2018-10-22
 */
@DisplayName("LeetCode #67: Add Binary")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("1111", "1111", "11110"),
                Arguments.of("11", "1", "100"),
                Arguments.of("10", "1", "11"),
                Arguments.of("1010", "1011", "10101")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void addBinary(String v1, String v2, String expected) {
        assertEquals(
                expected,
                new Solution().addBinary(v1, v2)
        );
    }
}