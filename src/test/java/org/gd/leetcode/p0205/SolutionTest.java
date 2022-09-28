package org.gd.leetcode.p0205;

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
 * Test for {@link org.gd.leetcode.p0205.Solution}.
 *
 * @author Horkhover Dmytro
 * @see Solution
 * @since 2022-09-28
 */
@DisplayName("LeetCode #205: Isomorphic Strings")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    @NonNull
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("babc", "baba", false),
                Arguments.of("egg", "add", true),
                Arguments.of("foo", "bar", false),
                Arguments.of("paper", "title", true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @SneakyThrows
    void test_isIsomorphic(String s, String t, boolean expected) {
        val solution = new Solution();
        val actual = solution.isIsomorphic(s, t);
        assertThat(actual).isEqualTo(expected);
    }
}