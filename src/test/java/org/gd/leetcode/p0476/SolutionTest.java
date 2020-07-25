package org.gd.leetcode.p0476;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-25
 */
@DisplayName("LeetCode #476: Number Complement")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(2, 1),
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(5, 2),
                Arguments.of(346, 165)
        );
    }

    @ParameterizedTest(name = "{1} is complement of {0}")
    @MethodSource("args")
    @DisplayName("FindComplement")
    void test_FindComplement(int num, int expected) {
        assertEquals(expected, new Solution().findComplement(num));
    }
}