package org.gd.leetcode.p0132;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @see org.gd.leetcode.p0131.SolutionTest
 * @since 2020-07-13
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode 132: Palindrome Partitioning II")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("caba", 1),
                Arguments.of("aab", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Partition")
    void test_MinCut(String word, int expected) {
        assertEquals(expected, new Solution().minCut(word));
    }
}