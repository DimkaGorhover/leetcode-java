package org.gd.leetcode.p0304;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Test for {@link NumMatrix}
 *
 * @see org.gd.leetcode.p0303.NumArrayTest
 * @since 2019-09-13
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #304: Range Sum Query 2D - Immutable")
class NumMatrixTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                new CaseImpl(
                        new int[][]{
                                {1, 2, 3, 4, 5}
                        },
                        java.util.Arrays.asList(
                                SubCase.builder()
                                        .setLeft(0, 0)
                                        .setRight(0, 1)
                                        .setExpected(3)
                                        .build(),
                                SubCase.builder()
                                        .setLeft(0, 0)
                                        .setRight(0, 2)
                                        .setExpected(6)
                                        .build()
                        )),
                new CaseImpl(
                        new int[][]{
                                {3, 0, 1, 4, 2},
                                {5, 6, 3, 2, 1},
                                {1, 2, 0, 1, 5},
                                {4, 1, 0, 1, 7},
                                {1, 0, 3, 0, 5}
                        },
                        java.util.Arrays.asList(
                                SubCase.builder()
                                        .setLeft(2, 1)
                                        .setRight(4, 3)
                                        .setExpected(8)
                                        .build(),
                                SubCase.builder()
                                        .setLeft(1, 1)
                                        .setRight(2, 2)
                                        .setExpected(11)
                                        .build(),
                                SubCase.builder()
                                        .setLeft(1, 2)
                                        .setRight(2, 4)
                                        .setExpected(12)
                                        .build()
                        )
                )
        );
    }

    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("NumMatrix")
    void test_NumMatrix(Case aCase) {
        var numMatrix = new NumMatrix(aCase.matrix());
        for (SubCase c : aCase)
            c.doAssert(numMatrix);
    }

    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("EachRowSumSolution")
    void test_EachRowSumSolution(Case aCase) {
        var solution = new EachRowSumSolution(aCase.matrix());
        for (SubCase subCase : aCase)
            subCase.doAssert(solution);
    }

    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("DynamicProgrammingSolution")
    void test_DynamicProgrammingSolution(Case aCase) {
        var solution = new DynamicProgrammingSolution(aCase.matrix());
        for (SubCase subCase : aCase)
            subCase.doAssert(solution);
    }

    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("QuadSolution")
    void test_QuadSolution(Case aCase) {
        var solution = new QuadSolution(aCase.matrix());
        for (SubCase subCase : aCase)
            subCase.doAssert(solution);
    }

}