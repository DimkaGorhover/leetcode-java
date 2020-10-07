package org.gd.leetcode.p0338;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static Stream<Arguments> args() {

        Stream<Supplier<ISolution>> solutions = Stream.of(Solution::new, DPSolution::new);

        return solutions
                .flatMap(iSolutionSupplier -> Stream.of(
                        Arguments.of(iSolutionSupplier, 2, new int[]{0, 1, 1})
                ));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #338: Counting Bits")
    void countBits(Supplier<ISolution> solution, int num, int[] expected) {
        assertArrayEquals(expected, solution.get().countBits(num));
    }
}