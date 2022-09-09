package org.gd.leetcode.p0011;

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
 * Test for {@link org.gd.leetcode.p0011.Solution}.
 *
 * @author Horkhover Dmytro
 * @see Solution
 * @since 2022-09-09
 */
@DisplayName("LeetCode #11: Container With Most Water")
class SolutionTest {

    @NonNull
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                Arguments.of(new int[]{1, 1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Test for maxArea")
    @SneakyThrows
    void test_maxArea(int[] heights, int expected) {
        val solution = new Solution();
        assertThat(solution.maxArea(heights)).isEqualTo(expected);
    }
}
