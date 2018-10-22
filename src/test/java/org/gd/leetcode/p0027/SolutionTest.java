package org.gd.leetcode.p0027;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
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
                arguments(new int[]{3, 2, 2, 3}, 3, new int[]{2, 2}),
                arguments(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[]{0, 1, 3, 0, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void removeElement(int[] input, int val, int[] expectedArray) {

        final int actualSize = new Solution().removeElement(input, val);

        final List<Integer> expectedList = Arrays.stream(expectedArray).boxed().collect(Collectors.toList());
        final List<Integer> actualList   = Arrays.stream(input).limit(actualSize).boxed().collect(Collectors.toList());

        assertEquals(expectedArray.length, actualSize);
        assertEquals(expectedList, actualList);
    }
}