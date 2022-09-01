package org.gd.leetcode.p0131;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-07-13
 */
@DisplayName("LeetCode #131: Palindrome Partitioning")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("caba", java.util.Arrays.asList(
                        java.util.Arrays.asList("c", "aba"),
                        java.util.Arrays.asList("c", "a", "b", "a")
                )),
                Arguments.of("aab", java.util.Arrays.asList(
                        java.util.Arrays.asList("aa", "b"),
                        java.util.Arrays.asList("a", "a", "b")
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Partition")
    void test_Partition(String word, List<List<String>> expected) {

        List<List<String>> actual = new Solution().partition(word);

        assertEquals(expected.size(), actual.size());

        for (List<String> strings : expected) {
            assertTrue(actual.contains(strings));
        }

    }
}