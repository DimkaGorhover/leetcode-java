package org.gd.leetcode.p0881;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-12
 */
@DisplayName("LeetCode #881: Boats to Save People")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 2, 1}, 3, 3),
                Arguments.of(new int[]{5, 1, 4, 2}, 6, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Sort Solution")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_001(int[] people, int limit, int expected) {
        assertEquals(expected, new SortTwoPointersSolution().numRescueBoats(people, limit));
    }
}
