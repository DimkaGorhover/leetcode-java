package org.gd.leetcode.p0349;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.gd.common.CollectionUtils.setOf;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-14
 */
@DisplayName("LeetCode #349: Intersection of Two Arrays")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2, 2}, Set.of(2)),
                Arguments.of(new int[]{4, 9}, new int[]{9, 4, 9, 8, 4}, Set.of(9, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Hash Table Solution")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_HashTable(int[] nums1, int[] nums2, Set<Integer> expected) {
        assertEquals(expected, setOf(new HashTableSolution().intersection(nums1, nums2)));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Two Pointers Sort Solution")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_Intersection(int[] nums1, int[] nums2, Set<Integer> expected) {
        assertEquals(expected, setOf(new TwoPointersSortSolution().intersection(nums1, nums2)));
    }
}
