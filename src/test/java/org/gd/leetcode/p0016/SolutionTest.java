package org.gd.leetcode.p0016;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-12-15
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(
                        new int[]{-1, 0, 1, 2, -1, -4},
                        List.of(
                                List.of(-1, 0, 1),
                                List.of(-1, -1, 2)
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("ThreeSum")
    void test_ThreeSum(int[] input, List<List<Integer>> expected) {
        Assertions.assertEquals(
                expected,
                new Solution().threeSum(input)
        );
    }
}