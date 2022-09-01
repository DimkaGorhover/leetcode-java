package org.gd.leetcode.p1253;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-12
 */
@SuppressWarnings("SpellCheckingInspection")
@DisplayName("LeetCode #1253: Reconstruct a 2-Row Binary Matrix")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(2, 3, new int[]{2, 2, 1, 1}, org.gd.leetcode.common.CollectionUtils.setOf(java.util.Arrays.asList())),

                Arguments.of(2, 1, new int[]{1, 1, 1}, org.gd.leetcode.common.CollectionUtils.setOf(
                        java.util.Arrays.asList(
                                java.util.Arrays.asList(1, 1, 0),
                                java.util.Arrays.asList(0, 0, 1)),
                        java.util.Arrays.asList(
                                java.util.Arrays.asList(1, 0, 1),
                                java.util.Arrays.asList(0, 1, 0)),
                        java.util.Arrays.asList(
                                java.util.Arrays.asList(0, 1, 1),
                                java.util.Arrays.asList(1, 0, 0))
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("ReconstructMatrix")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_ReconstructMatrix(int upper, int lower, int[] colsum, Set<List<List<Integer>>> expected) {

        var actual = new Solution().reconstructMatrix(upper, lower, colsum);
        assertTrue(expected.contains(actual));
    }
}
