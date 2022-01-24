package org.gd.leetcode.p2138;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@see org.gd.leetcode.p2138.Solution}.
 *
 * @author Horkhover Dmytro
 * @see Solution
 * @since 2022-01-24
 */
@DisplayName("LeetCode #2138: Divide a String Into Groups of Size k")
class SolutionTest {

    @NonNull
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("abcdefghi", 3, "x", List.of("abc", "def", "ghi")),
                Arguments.of("abcdefghij", 3, "x", List.of("abc", "def", "ghi", "jxx"))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Test for divideString")
    @SneakyThrows
    void test_divideString(String s, int k, char fill, List<String> expected) {
        String[] actual = new Solution().divideString(s, k, fill);
        assertThat(List.of(actual)).isEqualTo(expected);
    }
}
