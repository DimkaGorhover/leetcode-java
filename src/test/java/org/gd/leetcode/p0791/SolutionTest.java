package org.gd.leetcode.p0791;

import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link org.gd.leetcode.p0791.Solution}.
 *
 * @author Horkhover Dmytro
 * @see Solution
 * @since 2022-09-29
 */
@DisplayName("LeetCode #791: Custom Sort String")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    @NonNull
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("cba", "abcd", "cbad"),
                Arguments.of("cbafg", "abcd", "cbad")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @SneakyThrows
    void test_customSortString(String order, String s, String expected) {
        val actual = new Solution().customSortString(order, s);
        assertThat(actual).isEqualTo(expected);
    }
}
