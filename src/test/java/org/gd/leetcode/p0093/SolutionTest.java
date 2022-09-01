package org.gd.leetcode.p0093;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-12-11
 */
@Execution(CONCURRENT)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments("010010", org.gd.leetcode.common.CollectionUtils.setOf("0.10.0.10", "0.100.1.0")),
                arguments("111111111111", org.gd.leetcode.common.CollectionUtils.setOf("111.111.111.111")),
                arguments("1111", org.gd.leetcode.common.CollectionUtils.setOf("1.1.1.1")),
                arguments("25525511135", org.gd.leetcode.common.CollectionUtils.setOf("255.255.11.135", "255.255.111.35"))
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