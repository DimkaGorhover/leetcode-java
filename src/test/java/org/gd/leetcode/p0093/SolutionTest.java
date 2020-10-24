package org.gd.leetcode.p0093;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-12-11
 */
@DisplayName("LeetCode #93: Restore IP Addresses")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("010010", Set.of("0.10.0.10", "0.100.1.0")),
                Arguments.of("111111111111", Set.of("111.111.111.111")),
                Arguments.of("1111", Set.of("1.1.1.1")),
                Arguments.of("25525511135", Set.of("255.255.11.135", "255.255.111.35"))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("RestoreIpAddresses")
    void test_RestoreIpAddresses(String text, Set<String> expected) {
        Set<String> actual = new HashSet<>(new Solution().restoreIpAddresses(text));
        assertEquals(expected, actual);
    }
}