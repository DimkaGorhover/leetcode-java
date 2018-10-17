package org.gd.leetcode.p0118;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Gorkhover D.
 * @since 2018-10-17
 */
class PascalsTriangleSolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.arguments(5, List.of(
                        List.of(1),
                        List.of(1, 1),
                        List.of(1, 2, 1),
                        List.of(1, 3, 3, 1),
                        List.of(1, 4, 6, 4, 1)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void generate(int numRows, List<List<Integer>> expected) {
        assertEquals(expected, new PascalsTriangleSolution().generate(numRows));
    }
}