package org.gd.leetcode.p0118;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Gorkhover D.
 * @see org.gd.leetcode.p0119.SolutionTest
 * @since 2018-10-17
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #118: Pascals Triangle")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.arguments(1, java.util.Arrays.asList(
                        /* 0 */ java.util.Arrays.asList(1)
                )),
                Arguments.arguments(2, java.util.Arrays.asList(
                        /* 0 */ java.util.Arrays.asList(1),
                        /* 1 */ java.util.Arrays.asList(1, 1)
                )),
                Arguments.arguments(3, java.util.Arrays.asList(
                        /* 0 */ java.util.Arrays.asList(1),
                        /* 1 */ java.util.Arrays.asList(1, 1),
                        /* 2 */ java.util.Arrays.asList(1, 2, 1)
                )),
                Arguments.arguments(4, java.util.Arrays.asList(
                        /* 0 */ java.util.Arrays.asList(1),
                        /* 1 */ java.util.Arrays.asList(1, 1),
                        /* 2 */ java.util.Arrays.asList(1, 2, 1),
                        /* 3 */ java.util.Arrays.asList(1, 3, 3, 1)
                )),
                Arguments.arguments(5, java.util.Arrays.asList(
                        /* 0 */ java.util.Arrays.asList(1),
                        /* 1 */ java.util.Arrays.asList(1, 1),
                        /* 2 */ java.util.Arrays.asList(1, 2, 1),
                        /* 3 */ java.util.Arrays.asList(1, 3, 3, 1),
                        /* 4 */ java.util.Arrays.asList(1, 4, 6, 4, 1)
                )),
                Arguments.arguments(8, java.util.Arrays.asList(
                        /* 0 */ java.util.Arrays.asList(1),
                        /* 1 */ java.util.Arrays.asList(1, 1),
                        /* 2 */ java.util.Arrays.asList(1, 2, 1),
                        /* 3 */ java.util.Arrays.asList(1, 3, 3, 1),
                        /* 4 */ java.util.Arrays.asList(1, 4, 6, 4, 1),
                        /* 5 */ java.util.Arrays.asList(1, 5, 10, 10, 5, 1),
                        /* 6 */ java.util.Arrays.asList(1, 6, 15, 20, 15, 6, 1),
                        /* 7 */ java.util.Arrays.asList(1, 7, 21, 35, 35, 21, 7, 1)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void generate(int numRows, List<List<Integer>> expected) {
        assertEquals(expected, new Solution().generate(numRows));
    }
}