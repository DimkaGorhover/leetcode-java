package org.gd.leetcode.p0721;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-10-24
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(
                        List.of(
                                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                                List.of("Mary", "mary@mail.com"),
                                List.of("John", "johnnybravo@mail.com")
                        ),
                        List.of(
                                List.of("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
                                List.of("Mary", "mary@mail.com"),
                                List.of("John", "johnnybravo@mail.com")
                        )
                ),
                arguments(
                        List.of(
                                List.of("David", "David0@m.co", "David1@m.co"),
                                List.of("David", "David3@m.co", "David4@m.co"),
                                List.of("David", "David4@m.co", "David5@m.co"),
                                List.of("David", "David2@m.co", "David3@m.co"),
                                List.of("David", "David1@m.co", "David2@m.co")
                        ),
                        List.of(
                                List.of("David", "David0@m.co", "David1@m.co", "David2@m.co", "David3@m.co", "David4@m.co", "David5@m.co")
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("AccountsMerge")
    void test_AccountsMerge(List<List<String>> input, List<List<String>> expected) {
        Assertions.assertEquals(
                new HashSet<>(expected),
                new HashSet<>(new Solution().accountsMerge(input))
        );
    }
}