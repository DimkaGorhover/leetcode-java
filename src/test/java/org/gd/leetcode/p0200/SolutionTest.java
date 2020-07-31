package org.gd.leetcode.p0200;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-31
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(new char[][]{
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                }, 3),

                Arguments.of(new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                }, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("NumIslands")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_NumIslands(char[][] grid, int expected) {
        assertEquals(expected, new Solution().numIslands(grid));
    }
}