package org.gd.leetcode.p0066;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author Gorkhover D.
 * @since 2018-10-22
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
                arguments(new int[]{9, 9, 9}, new int[]{1, 0, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void plusOne(int[] input, int[] expected) {


        var actualList   = Arrays.stream(new Solution().plusOne(input)).boxed().collect(Collectors.toList());
        var expectedList = Arrays.stream(expected).boxed().collect(Collectors.toList());

        assertEquals(expectedList, actualList);
    }
}