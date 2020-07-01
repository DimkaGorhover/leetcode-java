package org.gd.leetcode.p0307;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link NumArray}
 *
 * @since 2019-09-18
 */
@DisplayName("LeetCode #307: range sum query mutable")
class NumArrayTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                TestCase.of(
                        new int[]{1, 2, 3, 4},
                        List.of(
                                SumSubCases.of(0, 2, 6),
                                UpdateSubCases.of(0, 3),
                                SumSubCases.of(0, 2, 8)
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SumRange")
    void test_SumRange(TestCase testCase) {
        NumArray numArray = new NumArray(testCase.nums);
        for (SubCase subCase : testCase)
            subCase.doAssert(numArray);
    }

    @RequiredArgsConstructor(access = AccessLevel.PACKAGE, staticName = "of")
    static class TestCase implements Arguments, Iterable<SubCase> {

        final int[] nums;
        final List<SubCase> subCases;

        @Override
        public Object[] get() { return new Object[]{this}; }

        @Nonnull
        @Override
        public Iterator<SubCase> iterator() {
            if (subCases.isEmpty())
                return Collections.emptyIterator();
            return subCases.iterator();
        }

        @Override
        public String toString() {
            return subCases.toString();
        }
    }

    interface SubCase {

        void doAssert(NumArray numArray) throws AssertionError;
    }

    @RequiredArgsConstructor(access = AccessLevel.PACKAGE, staticName = "of")
    static class UpdateSubCases implements SubCase {

        final int i, value;

        @Override
        public void doAssert(NumArray numArray) { numArray.update(i, value); }

        @Override
        public String toString() {
            return "Update{" + i + " -> " + value + '}';
        }
    }

    @RequiredArgsConstructor(access = AccessLevel.PACKAGE, staticName = "of")
    static class SumSubCases implements SubCase {

        final int leftBound, rightBound, expected;

        @Override
        public void doAssert(NumArray numArray) {
            assertEquals(expected, numArray.sumRange(leftBound, rightBound));
        }

        @Override
        public String toString() {
            return "Sum{(" + leftBound + "; " + rightBound + ") => " + expected + '}';
        }
    }
}