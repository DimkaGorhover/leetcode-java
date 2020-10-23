package org.gd.leetcode.p1002;

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
 * @since 2020-08-14
 */
@DisplayName("LeetCode #1002: Find Common Characters")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new String[]{"cool", "lock", "cook"}, List.of("c", "o")),
                Arguments.of(new String[]{"cool", "lock", "cook", "co"}, List.of("c", "o")),
                Arguments.of(new String[]{"bella", "label", "roller"}, List.of("e", "l", "l"))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("CommonChars")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_CommonChars(String[] A, List<String> expected) {
        assertEquals(expected, new Solution().commonChars(A));
    }
}
