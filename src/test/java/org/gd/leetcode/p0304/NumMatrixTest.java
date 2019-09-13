package org.gd.leetcode.p0304;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.annotation.Nonnull;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

/**
 * Test for {@link NumMatrix}
 *
 * @see org.gd.leetcode.p0303.NumArrayTest
 * @since 2019-09-13
 */
@SuppressWarnings("JavadocReference")
class NumMatrixTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                new Case(
                        new int[][]{
                                {3, 0, 1, 4, 2},
                                {5, 6, 3, 2, 1},
                                {1, 2, 0, 1, 5},
                                {4, 1, 0, 1, 7},
                                {1, 0, 3, 0, 5}
                        },
                        List.of(
                                new SubCase(2, 1, 4, 3, 8),
                                new SubCase(1, 1, 2, 2, 11),
                                new SubCase(1, 2, 2, 4, 12)
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SumRegion")
    void test_SumRegion(Case aCase) throws Exception {
        NumMatrix numMatrix = new NumMatrix(aCase.matrix);
        for (SubCase c : aCase) {
            Assertions.assertEquals(
                    c.expected,
                    numMatrix.sumRegion(c.row1, c.col1, c.row2, c.col2),
                    c::toString);
        }
    }

    static class Case implements Iterable<SubCase>, Arguments {

        final int[][] matrix;
        final List<SubCase> subCases;

        Case(int[][] matrix, List<SubCase> subCases) {
            this.matrix = requireNonNull(matrix, "\"nums\" cannot be null");
            this.subCases = requireNonNull(subCases, "\"subCases\" cannot be null");
        }

        @Nonnull
        @Override
        public Iterator<SubCase> iterator() { return subCases.iterator(); }

        @Override
        public Object[] get() { return new Object[]{this}; }
    }

    static class SubCase {

        final int row1, col1, row2, col2, expected;

        SubCase(int row1, int col1, int row2, int col2, int expected) {
            this.row1 = row1;
            this.col1 = col1;
            this.row2 = row2;
            this.col2 = col2;
            this.expected = expected;
        }

        @Override
        public String toString() {
            return String.format("[(%d:%d):(%d:%d)] --> %d", row1, col1, row2, col2, expected);
        }
    }
}