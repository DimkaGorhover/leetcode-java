package org.gd.leetcode.p0383;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@see org.gd.leetcode.p0383.Solution}.
 *
 * @author Horkhover Dmytro
 * @see Solution
 * @since 2022-01-14
 */
@DisplayName("Test For Class org.gd.leetcode.p0383.Solution")
class SolutionTest {

    @NonNull
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("a", "b", false),
                Arguments.of("aa", "ab", false),
                Arguments.of("aa", "aab", true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Test for canConstruct")
    @SneakyThrows
    void test_canConstruct(String ransomNote, String magazine, boolean expected) {
        assertThat(new Solution().canConstruct(ransomNote, magazine)).isEqualTo(expected);
    }
}