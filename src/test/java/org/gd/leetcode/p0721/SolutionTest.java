package org.gd.leetcode.p0721;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

/**
 * Test for {@link Solution};
 *
 * TODO: add test case https://leetcode.com/submissions/detail/185071294/
 *
 * @author Gorkhover D.
 * @since 2018-10-24
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                                Arrays.asList("Mary", "mary@mail.com"),
                                Arrays.asList("John", "johnnybravo@mail.com")
                        ),
                        Arrays.asList(
                                Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
                                Arrays.asList("Mary", "mary@mail.com"),
                                Arrays.asList("John", "johnnybravo@mail.com")
                        )
                ),
                Arguments.of(
                        Arrays.asList(
                                Arrays.asList("David", "David0@m.co", "David1@m.co"),
                                Arrays.asList("David", "David3@m.co", "David4@m.co"),
                                Arrays.asList("David", "David4@m.co", "David5@m.co"),
                                Arrays.asList("David", "David2@m.co", "David3@m.co"),
                                Arrays.asList("David", "David1@m.co", "David2@m.co")
                        ),
                        Arrays.asList(
                                Arrays.asList("David", "David0@m.co", "David1@m.co", "David2@m.co", "David3@m.co", "David4@m.co", "David5@m.co")
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