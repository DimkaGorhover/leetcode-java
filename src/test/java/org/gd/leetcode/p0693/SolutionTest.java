package org.gd.leetcode.p0693;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-07-09.07.2020
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(7, false),
                Arguments.of(5, true),
                Arguments.of(11, false),
                Arguments.of(5, true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("HasAlternatingBits")
    void test_HasAlternatingBits(int n, boolean expected) {
        assertEquals(expected, new Solution().hasAlternatingBits(n));
    }
}