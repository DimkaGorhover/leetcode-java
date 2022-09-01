package org.gd.leetcode.p0349;

import lombok.NonNull;
import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0350.SolutionTest
 * @since 2020-08-14
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #349: Intersection of Two Arrays")
class SolutionTest {

    @NonNull
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2}),
                Arguments.of(new int[]{4, 9}, new int[]{9, 4, 9, 8, 4}, new int[]{9, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Hash Table Solution")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_HashTable(int[] nums1, int[] nums2, int[] expected) {
        var solution = new HashTableSolution();
        var actual = solution.intersection(nums1, nums2);
        assertThat(actual).containsExactlyInAnyOrder(expected);
    }

    @SuppressWarnings("deprecation")
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Two Pointers Sort Solution")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_Intersection(int[] nums1, int[] nums2, int[] expected) {
        var solution = new TwoPointersSortSolution();
        var actual = solution.intersection(nums1, nums2);
        assertThat(actual).containsExactlyInAnyOrder(expected);
    }
}
