package org.gd.leetcode.p0058;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-12-19
 */
@DisplayName("LeetCode #58: Length of Last Word")
@Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("       ", 0),
                Arguments.of("Hello World", 5),
                Arguments.of("a ", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LengthOfLastWord")
    void test_LengthOfLastWord(String input, int expected) {
        assertEquals(expected, new Solution().lengthOfLastWord(input));
    }
}
