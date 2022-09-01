package org.gd.leetcode.p0419;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-02
 */
@DisplayName("LeetCode #419: Battleships in a Board")
@SuppressWarnings("SpellCheckingInspection")
class SolutionTest {

    private static char[][] board(String... strings) {
        requireNonNull(strings, "\"strings\" cannot be null");
        return Arrays.stream(strings)
                .map(String::toCharArray)
                .toArray(char[][]::new);
    }

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(board(
                        "..",
                        "XX"
                ), 1),
                Arguments.of(board("XXX...XXXXXX..XX..X"), 4),
                Arguments.of(board(
                        "X..X",
                        "...X",
                        "...X"
                ), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("CountBattleships")
    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    void test_CountBattleships(char[][] board, int expected) {
        assertEquals(expected, new Solution().countBattleships(board));
    }
}