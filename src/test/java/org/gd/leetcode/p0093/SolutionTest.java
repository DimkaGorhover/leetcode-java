package org.gd.leetcode.p0093;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-12-11
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                //Arguments.arguments("111111111111", List.of("111.111.111.111")),
                //Arguments.arguments("1111", List.of("1.1.1.1")),
                Arguments.arguments("25525511135", List.of("255.255.11.135", "255.255.111.35"))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("RestoreIpAddresses")
    void test_RestoreIpAddresses(String text, List<String> expected) {
        assertEquals(
                expected,
                new Solution().restoreIpAddresses(text)
        );
    }
}