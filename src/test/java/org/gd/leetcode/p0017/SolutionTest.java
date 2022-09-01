package org.gd.leetcode.p0017;

import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Gorkhover D.
 * @see Solution
 * @since 2018-10-25
 */
@DisplayName("LeetCode #17: Letter Combinations of a Phone Number")
class SolutionTest {

    @NonNull
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("23", java.util.Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
                Arguments.of("", java.util.Arrays.asList()),
                Arguments.of("2", java.util.Arrays.asList("a", "b", "c"))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void letterCombinations(String digits, List<String> expected) {
        assertThat(new Solution().letterCombinations(digits)).isEqualTo(expected);
    }
}
