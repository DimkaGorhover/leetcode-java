package org.gd.leetcode.p0027;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 * 
 * @author Gorkhover D.
 * @since 2018-10-22
 */
@DisplayName("LeetCode #27: Remove Element")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 2, 3}, 3, new int[]{2, 2}),
                Arguments.of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[]{0, 1, 3, 0, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void removeElement(int[] input, int val, int[] expectedArray) {

        final int actualSize = new Solution().removeElement(input, val);

        final List<Integer> expectedList = Arrays.stream(expectedArray).boxed().collect(Collectors.toList());
        final List<Integer> actualList = Arrays.stream(input).limit(actualSize).boxed().collect(Collectors.toList());

        assertEquals(expectedArray.length, actualSize);
        assertEquals(expectedList, actualList);
    }
}