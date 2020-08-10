package org.gd.leetcode.p0692;

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
 * @since 2020-08-10
 */
@DisplayName("LeetCode #692: Top K Frequent Words")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(
                        new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},
                        4,
                        List.of("the", "is", "sunny", "day")),

                Arguments.of(
                        new String[]{"i", "love", "leetcode", "i", "love", "coding"},
                        2,
                        List.of("i", "love"))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("TopKFrequent")
    void test_TopKFrequent(String[] words, int k, List<String> expected) {
        assertEquals(expected, new Solution().topKFrequent(words, k));
    }
}