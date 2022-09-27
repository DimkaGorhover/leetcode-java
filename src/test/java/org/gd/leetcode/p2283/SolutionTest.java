package org.gd.leetcode.p2283;

import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link org.gd.leetcode.p2283.Solution}.
 *
 * @author Horkhover Dmytro
 * @see Solution
 * @since 2022-09-27
 */
@DisplayName("LeetCode #2283: Check if Number Has Equal Digit Count and Digit Value")
class SolutionTest {

    @NonNull
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("1210", true),
                Arguments.of("030", false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @SneakyThrows
    void test_digitCount(String num, boolean expected) {
        val solution = new Solution();
        assertThat(solution.digitCount(num)).isEqualTo(expected);
    }
}