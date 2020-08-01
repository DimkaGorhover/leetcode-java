package org.gd.leetcode.p0303;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link NumArray}
 *
 * @see org.gd.leetcode.p0304.NumMatrixTest
 * @since 2019-09-13
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #303: Range Sum Query Immutable")
class NumArrayTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                new Case(new int[]{-2, 0, 3, -5, 2, -1}, List.of(
                        new SubCase(0, 2, 1),
                        new SubCase(-1, 2, 1),
                        new SubCase(0, 0, -2),
                        new SubCase(1, 1, 0),
                        new SubCase(2, 1, 0),
                        new SubCase(2, 5, -1),
                        new SubCase(0, 5, -3)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SumRange")
    void test_SumRange(Case aCase) {

        NumArray numArray = new NumArray(aCase.nums);
        for (SubCase subCase : aCase) {
            assertEquals(subCase.expected, numArray.sumRange(subCase.i, subCase.j), subCase::toString);
        }
    }

    static class Case implements Iterable<SubCase>, Arguments {

        final int[] nums;
        final List<SubCase> subCases;

        Case(int[] nums, List<SubCase> subCases) {

            requireNonNull(nums, "\"nums\" cannot be null");
            requireNonNull(subCases, "\"subCases\" cannot be null");

            this.nums = nums;
            this.subCases = subCases;
        }

        @Nonnull
        @Override
        public Iterator<SubCase> iterator() {
            return subCases.iterator();
        }

        @Override
        public Object[] get() { return new Object[]{this}; }

        @Override
        public String toString() {
            return Arrays.toString(nums);
        }
    }

    static class SubCase {

        final int i, j, expected;

        SubCase(int i, int j, int expected) {
            this.i = i;
            this.j = j;
            this.expected = expected;
        }

        @Override
        public String toString() {
            return String.format("[%d:%d] --> %d", i, j, expected);
        }
    }
}