package org.gd.leetcode.p0342;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0231.SolutionTest
 * @since 2020-08-04
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #342: Power of Four")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(17, false),
                Arguments.of(16, true),
                Arguments.of(2, false),
                Arguments.of(5, false),
                Arguments.of(7, false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("IsPowerOfFour")
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    void test_IsPowerOfFour(int num, boolean expected) {
        assertEquals(expected, new Solution().isPowerOfFour(num));
    }
}
