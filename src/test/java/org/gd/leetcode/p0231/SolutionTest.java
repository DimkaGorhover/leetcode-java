package org.gd.leetcode.p0231;

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
 * @see org.gd.leetcode.p0342.SolutionTest
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #231: Power of Two")
@Timeout(value = 5, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(-1, false),
                Arguments.of(2, true),
                Arguments.of(536870912, true),
                Arguments.of(3, false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Is Power Of Two")
    void test(int n, boolean expected) {
        assertEquals(expected, new Solution().isPowerOfTwo(n));
    }
}
