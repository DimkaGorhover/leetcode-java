package org.gd.leetcode.p1705;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link Solution}.
 */
@DisplayName("LeetCode #1705: Maximum Number of Eaten Apples")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(
                        new int[]{
                                1, 10, 17, 10, 12, 6, 20, 8, 8, 22, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 5, 2, 1, 0, 0, 0, 0, 0, 0, 23},
                        new int[]{
                                19999, 11, 18, 22, 5, 2, 14, 5, 20, 7, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 1, 4, 2, 7, 0, 0, 0, 0, 0, 0, 1},
                        37),

                Arguments.of(
                        new int[]{1, 2, 3, 5, 2},
                        new int[]{3, 2, 1, 4, 2},
                        7),

                Arguments.of(
                        new int[]{3, 0, 0, 0, 0, 2},
                        new int[]{3, 0, 0, 0, 0, 2},
                        5)
        );


    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Heap Apples")
    void test001(int[] apples, int[] days, int expected) {
        assertThat(apples).hasSameSizeAs(days);
        assertThat(new HeapSolution().eatenApples(apples, days)).isEqualTo(expected);
    }
}
