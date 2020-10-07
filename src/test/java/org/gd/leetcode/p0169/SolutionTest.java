package org.gd.leetcode.p0169;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-07-13
 */
@DisplayName("LeetCode #169: Majority Element")
class SolutionTest {

    private static Stream<Arguments> args() {

        var sortSolution = new SortSolution();
        var hashMapSolution = new HashMapSolution();

        return Stream
                .<Supplier<Solution>>of(
                        () -> sortSolution,
                        () -> hashMapSolution,
                        SortSolution::new,
                        HashMapSolution::new
                )
                .flatMap(ss -> Stream.of(
                        Arguments.of(ss, new int[]{3, 2, 3}, 3),
                        Arguments.of(ss, new int[]{2, 2, 2, 1, 1}, 2),
                        Arguments.of(ss, new int[]{2, 2, 1, 1, 1, 2, 2}, 2)
                ));
    }

    @ParameterizedTest(name = "expected = {1}, {0}")
    @MethodSource("args")
    @DisplayName("MajorityElement")
    void test_MajorityElement(Supplier<Solution> s, int[] nums, int expected) {
        var solution = s.get();
        int actual = solution.majorityElement(Arrays.copyOf(nums, nums.length));
        assertEquals(expected, actual);
    }
}