package org.gd.leetcode.p0300;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@see org.gd.leetcode.p0300.Solution}.
 *
 * @author Horkhover Dmytro
 * @see Solution
 * @since 2022-01-14
 */
@DisplayName("LeetCode #383: Ransom Note")
class SolutionTest {

    @NonNull
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4),
                Arguments.of(new int[]{0, 1, 0, 3, 2, 3}, 4),
                Arguments.of(new int[]{7, 7, 7, 7, 7, 7, 7}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Test for lengthOfLIS")
    @SneakyThrows
    void test_lengthOfLIS(int[] nums, int expected) {
        assertThat(new Solution().lengthOfLIS(nums)).isEqualTo(expected);
    }
}