package org.gd.leetcode.p0415;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-02
 */
@DisplayName("LeetCode #415: Add Strings")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("10", "999"),
                Arguments.of("23", "464")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("AddStrings")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_AddStrings(String num1, String num2) {

        String expected = new BigInteger(num1, 10).add(new BigInteger(num2, 10)).toString(10);

        assertEquals(expected, new Solution().addStrings(num1, num2));
    }
}