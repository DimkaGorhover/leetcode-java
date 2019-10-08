package org.gd.leetcode.p0118;

import org.junit.jupiter.api.parallel.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Gorkhover D.
 * @since 2018-10-17
 */
@Execution(ExecutionMode.CONCURRENT)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.arguments(1, List.of(
                        /* 0 */ List.of(1)
                )),
                Arguments.arguments(2, List.of(
                        /* 0 */ List.of(1),
                        /* 1 */ List.of(1, 1)
                )),
                Arguments.arguments(3, List.of(
                        /* 0 */ List.of(1),
                        /* 1 */ List.of(1, 1),
                        /* 2 */ List.of(1, 2, 1)
                )),
                Arguments.arguments(4, List.of(
                        /* 0 */ List.of(1),
                        /* 1 */ List.of(1, 1),
                        /* 2 */ List.of(1, 2, 1),
                        /* 3 */ List.of(1, 3, 3, 1)
                )),
                Arguments.arguments(5, List.of(
                        /* 0 */ List.of(1),
                        /* 1 */ List.of(1, 1),
                        /* 2 */ List.of(1, 2, 1),
                        /* 3 */ List.of(1, 3, 3, 1),
                        /* 4 */ List.of(1, 4, 6, 4, 1)
                )),
                Arguments.arguments(6, List.of(
                        /* 0 */ List.of(1),
                        /* 1 */ List.of(1, 1),
                        /* 2 */ List.of(1, 2, 1),
                        /* 3 */ List.of(1, 3, 3, 1),
                        /* 4 */ List.of(1, 4, 6, 4, 1),
                        /* 5 */ List.of(1, 5, 10, 10, 5, 1)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void generate(int numRows, List<List<Integer>> expected) {
        assertEquals(expected, new Solution().generate(numRows));
    }
}