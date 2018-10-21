package org.gd.leetcode.p0026;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(new int[]{1, 1, 2}, 2, new int[]{1, 2}),
                arguments(new int[]{1, 1, 2, 2, 2, 3, 4, 4}, 4, new int[]{1, 2, 3, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void removeDuplicates(int[] input, int expectedSize, int[] expectedArray) {

        int actualSize = new Solution().removeDuplicates(input);

        List<Integer> expected = Arrays.stream(expectedArray).boxed().collect(Collectors.toList());
        List<Integer> actual = Arrays.stream(input).limit(expectedSize).boxed().collect(Collectors.toList());

        assertEquals(expectedSize, actualSize);
        assertEquals(expected, actual);
    }
}