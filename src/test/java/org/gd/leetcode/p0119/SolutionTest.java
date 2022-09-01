package org.gd.leetcode.p0119;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0118.SolutionTest
 * @since 2018-12-21
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #119: Pascals Triangle II")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(3, Arrays.asList(1, 3, 3, 1)),
                Arguments.of(4, Arrays.asList(1, 4, 6, 4, 1)),
                Arguments.of(5, Arrays.asList(1, 5, 10, 10, 5, 1)),
                Arguments.of(7, Arrays.asList(1, 7, 21, 35, 35, 21, 7, 1)),
                Arguments.of(13, Arrays.asList(1, 13, 78, 286, 715, 1287, 1716, 1716, 1287, 715, 286, 78, 13, 1)),
                Arguments.of(20, Arrays.asList(1, 20, 190, 1140, 4845, 15504, 38760, 77520, 125970, 167960, 184756, 167960, 125970, 77520, 38760, 15504, 4845, 1140, 190, 20, 1))
        );
    }

    @SuppressWarnings("deprecation")
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("My Solution")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_MySolution(int level, List<Integer> expected) {
        assertEquals(expected, new MySolution().getRow(level));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Reference")
    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    void test_Reference(int level, List<Integer> expected) {
        assertEquals(expected, new ReferenceSolution().getRow(level));
    }
}