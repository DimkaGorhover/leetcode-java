package org.gd.leetcode.p0017;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author Gorkhover D.
 * @since 2018-10-25
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments("23", List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void letterCombinations(String digits, List<String> expected) {
        assertEquals(
                expected,
                new Solution().letterCombinations(digits)
        );
    }
}