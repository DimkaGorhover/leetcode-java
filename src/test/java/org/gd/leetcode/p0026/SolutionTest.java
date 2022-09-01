package org.gd.leetcode.p0026;

import org.gd.leetcode.common.ArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 */
@DisplayName("LeetCode #26: Remove Duplicates from Sorted Array")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(
                        new int[]{1, 1, 2},
                        new int[]{1, 2}),

                Arguments.of(
                        new int[]{1, 1, 2, 2, 2, 3, 4, 4},
                        new int[]{1, 2, 3, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void removeDuplicates(int[] input, int[] expected) {

        int actualSize = new Solution().removeDuplicates(input);

        assertEquals(expected.length, actualSize);

        assertEquals(
                ArrayUtils.toString(expected, 0, actualSize),
                ArrayUtils.toString(input, 0, actualSize));
    }
}