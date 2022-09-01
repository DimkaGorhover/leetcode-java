package org.gd.leetcode.p0169;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @see HashMapSolution
 * @see SortSolution
 * @see BoyerMooreVotingSolution
 * @since 2020-07-13
 */
@DisplayName("LeetCode #169: Majority Element")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 3},             3),
                Arguments.of(new int[]{2, 2, 2, 1, 1},       2),
                Arguments.of(new int[]{2, 2, 1, 1, 1, 2, 2}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Sort Solution")
    void test_SortSolution(int[] nums, int expected) {
        assertThat(new SortSolution().majorityElement(nums))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("HashMap Solution")
    void test_HashMapSolution(int[] nums, int expected) {
        assertThat(new HashMapSolution().majorityElement(nums))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Boyer-Moore Voting Solution")
    void test_BoyerMooreVoting(int[] nums, int expected) {
        assertThat(new BoyerMooreVotingSolution().majorityElement(nums))
                .isEqualTo(expected);
    }
}
