package org.gd.leetcode.p0989;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0066.Solution
 * @see org.gd.leetcode.p0066.SolutionTest
 * @since 2020-08-19
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #989: Add to Array-Form of Integer")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 0, 0}, 34, List.of(1, 2, 3, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("AddToArrayForm")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_AddToArrayForm(int[] A, int K, List<Integer> expected) {
        assertEquals(expected, new Solution().addToArrayForm(A, K));
    }
}
