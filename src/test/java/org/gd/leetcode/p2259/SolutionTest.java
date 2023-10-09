package org.gd.leetcode.p2259;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}.
 *
 * @author Horkhover Dmytro
 * @see Solution
 * @since 2023-10-09
 */
@DisplayName("LeetCode #2259: Remove Digit From Number to Maximize Result")
class SolutionTest {

    @NonNull
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("123", '3', "12"),
                Arguments.of("1231", '1', "231"),
                Arguments.of("551", '5', "51"),
                Arguments.of("133235", '3', "13325"),
                Arguments.of("73197", '7', "7319")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Test for removeDigit")
    @SneakyThrows
    void test_removeDigit(String number, char digit, String expected) {
        assertEquals(expected, new Solution().removeDigit(number, digit));
    }
}
