package org.gd.leetcode.p0212;

import lombok.var;
import org.gd.leetcode.common.IOUtils;
import org.gd.leetcode.common.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.gd.leetcode.common.CollectionUtils.sortedListOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-10-25
 */
@DisplayName("LeetCode #212: Word Search II")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(
                        new char[][]{
                                {'s', 'e', 'e', 'n', 'e', 'w'},
                                {'t', 'm', 'r', 'i', 'v', 'a'},
                                {'o', 'b', 's', 'i', 'b', 'd'},
                                {'w', 'm', 'y', 's', 'e', 'n'},
                                {'l', 't', 's', 'n', 's', 'a'},
                                {'i', 'e', 'z', 'l', 'g', 'n'},
                        },
                        Utils.get(() -> {
                            try (var resource = IOUtils.resource(SolutionTest.class, "test_case_001_words.txt")) {
                                return resource.readLine().split(",");
                            }
                        }),
                        Utils.get(() -> {
                            try (var resource = IOUtils.resource(SolutionTest.class, "test_case_001_expected.txt")) {
                                return sortedListOf(resource.readLine().split(","));
                            }
                        })),

                Arguments.of(
                        new char[][]{
                                {'a', 'a'}
                        },
                        new String[]{"a", "a"},
                        sortedListOf("a")),

                Arguments.of(
                        new char[][]{
                                {'a'},
                                {'a'}
                        },
                        new String[]{"a", "a"},
                        sortedListOf("a")),

                Arguments.of(
                        new char[][]{
                                {'o', 'a', 'a', 'n'},
                                {'e', 't', 'a', 'e'},
                                {'i', 'h', 'k', 'r'},
                                {'i', 'f', 'l', 'v'}
                        },
                        new String[]{"oath", "pea", "eat", "rain"},
                        sortedListOf("eat", "oath"))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("FindWords")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_FindWords(char[][] board, String[] words, List<String> expected) {
        List<String> actual = new Solution().findWords(board, words);
        assertEquals(expected, sortedListOf(actual));
    }
}
