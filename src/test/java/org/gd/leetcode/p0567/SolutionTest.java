package org.gd.leetcode.p0567;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-25
 */
@DisplayName("LeetCode #567: Permutation in String")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("hello", "ooolleoooleh", false),
                Arguments.of("adc", "dcda", true),
                Arguments.of("ab", "eidbaooo", true),
                Arguments.of("ab", "eidboaoo", false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("CheckInclusion")
    void test_CheckInclusion(String s1, String s2, boolean expected) {
        assertEquals(expected, new Solution().checkInclusion(s1, s2));
    }
}