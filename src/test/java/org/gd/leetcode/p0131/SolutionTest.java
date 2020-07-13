package org.gd.leetcode.p0131;

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
 * @see org.gd.leetcode.p0132.Solution
 * @since 2020-07-13
 */
@SuppressWarnings("JavadocReference")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("caba", List.of(
                        List.of("c", "aba"),
                        List.of("c", "a", "b", "a")
                )),
                Arguments.of("aab", List.of(
                        List.of("aa", "b"),
                        List.of("a", "a", "b")
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