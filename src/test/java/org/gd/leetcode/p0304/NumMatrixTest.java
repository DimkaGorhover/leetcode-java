package org.gd.leetcode.p0304;

import org.gd.leetcode.p0304.NumMatrix.Solution;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.parallel.ExecutionMode.*;

/**
 * Test for {@link NumMatrix}
 *
 * @see org.gd.leetcode.p0303.NumArrayTest
 * @since 2019-09-13
 */
@SuppressWarnings("JavadocReference")
@Execution(CONCURRENT)
class NumMatrixTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                new CaseImpl(
                        new int[][]{
                                {1, 2, 3, 4, 5}
                        },
                        List.of(
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
                        List.of(
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

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SumRegion")
    void test_SumRegion(Case aCase) throws Exception {

        NumMatrix numMatrix = new NumMatrix(aCase.getMatrix());
        Solution linearMatrixSolution = new NumMatrix.LinearMatrixSolution(aCase.getMatrix());
        Solution matrixSolution = new NumMatrix.DynamicProgrammingSolution(aCase.getMatrix());
        Solution quadSolution = new NumMatrix.QuadSolution(aCase.getMatrix());

        for (SubCase c : aCase) {
            c.doAssert(numMatrix);
            c.doAssert(linearMatrixSolution);
            c.doAssert(matrixSolution);
            c.doAssert(quadSolution);
        }
    }
}