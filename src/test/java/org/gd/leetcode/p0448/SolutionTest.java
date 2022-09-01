package org.gd.leetcode.p0448;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @since 2019-09-13
 */
@DisplayName("LeetCode #448: Find All Numbers Disappeared in an Array")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 2, 7, 8, 2, 3, 1}, java.util.Arrays.asList(5, 6))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("FindDisappearedNumbers")
    void test_FindDisappearedNumbers(int[] input, List<Integer> expected) {
        assertEquals(expected, new Solution().findDisappearedNumbers(input));
    }
}