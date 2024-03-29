package org.gd.leetcode.p0520;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-01
 */
@DisplayName("LeetCode #520: Detect Capital")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("LKSKDJLKSJD", true),
                Arguments.of("LKskdjlksjd", false),
                Arguments.of("USA", true),
                Arguments.of("leetcode", true),
                Arguments.of("leetCode", false),
                Arguments.of("Leetcode", true),
                Arguments.of("LeetCode", false),
                Arguments.of("Google", true),
                Arguments.of("google", true),
                Arguments.of("g", true),
                Arguments.of("G", true),
                Arguments.of("gg", true),
                Arguments.of("gG", false),
                Arguments.of("Gg", true),
                Arguments.of("ggg", true),
                Arguments.of("Ggg", true),
                Arguments.of("GGg", false),
                Arguments.of("gGg", false),
                Arguments.of("ggG", false),
                Arguments.of("GgG", false),
                Arguments.of("GGG", true),
                Arguments.of("gGG", false),
                Arguments.of("GggG", false),
                Arguments.of("gggG", false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("DetectCapitalUse")
    @Timeout(value = 20, unit = TimeUnit.MILLISECONDS)
    void test_DetectCapitalUse(String word, boolean expected) {
        assertEquals(expected, new Solution().detectCapitalUse(word));
    }
}