package org.gd.leetcode.p0017;

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
 * @author Gorkhover D.
 * @since 2018-10-25
 */
@DisplayName("LeetCode #17: Letter Combinations of a Phone Number")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("23", List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
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