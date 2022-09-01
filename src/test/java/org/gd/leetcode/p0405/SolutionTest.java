package org.gd.leetcode.p0405;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-04
 */
@DisplayName("LeetCode #405: Convert a Number to Hexadecimal")
@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 26, -18, Integer.MAX_VALUE, Integer.MIN_VALUE})
    @DisplayName("ToHex")
    void test_ToHex(int num) {
        String expected = new JavaSolution().toHex(num);
        String actual = new LoopSolution().toHex(num);
        assertEquals(expected, actual);
    }
}