package org.gd.leetcode.p0389;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-31
 */
@DisplayName("LeetCode #389: Find the Difference")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("abcd", "abcde", 'e'),
                Arguments.of("a", "aa", 'a')
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Hash Table")
    void test_HashTableSolution(String s, String t, char expected) {
        assertEquals(expected, new HashTableSolution().findTheDifference(s, t));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Bit Manipulation")
    void test_BitManipulationSolution(String s, String t, char expected) {
        assertEquals(expected, new BitManipulationSolution().findTheDifference(s, t));
    }
}