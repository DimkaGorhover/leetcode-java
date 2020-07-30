package org.gd.leetcode.p0442;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.gd.common.ArrayUtils.copy;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-30
 */
@DisplayName("LeetCode #442: Find All Duplicates in an Array")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 2, 7, 8, 2, 3, 1}, List.of(2, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("FindDuplicates")
    void test_FindDuplicates(int[] nums, List<Integer> expected) {
        List<Integer> actual = new Solution().findDuplicates(copy(nums));
        actual.sort(Comparator.naturalOrder());
        assertEquals(expected, actual);
    }
}