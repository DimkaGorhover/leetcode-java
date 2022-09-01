package org.gd.leetcode.p1157;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link MajorityChecker}
 *
 * @since 2019-09-23
 */
@DisplayName("LeetCode #1157: Online Majority Element In Subarray")
class MajorityCheckerTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                new TestCase(new int[]{1, 1, 2, 2, 1, 1}, org.gd.leetcode.common.CollectionUtils.setOf(
                        new SubCase(0, 5, 4, 1),
                        new SubCase(0, 3, 3, -1),
                        new SubCase(2, 3, 2, 2)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Query")
    void test_Query(TestCase testCase) throws Exception {

        MajorityChecker majorityChecker = new MajorityChecker(testCase.arr);
        for (SubCase subCase : testCase)
            subCase.doAssert(majorityChecker);
    }

    @RequiredArgsConstructor(access = AccessLevel.PACKAGE)
    static class TestCase implements Arguments, Iterable<SubCase> {

        final int[] arr;
        final Set<SubCase> subCases;

        @Override
        public Object[] get() { return new Object[]{this}; }

        @Override
        public Iterator<SubCase> iterator() {
            if (subCases.isEmpty())
                return Collections.emptyIterator();
            return subCases.iterator();
        }
    }

    @RequiredArgsConstructor(access = AccessLevel.PACKAGE)
    static class SubCase {
        final int left;
        final int right;
        final int threshold;
        final int expected;

        void doAssert(MajorityChecker majorityChecker) {
            requireNonNull(majorityChecker, "\"majorityChecker\" cannot be null");
            assertEquals(expected, majorityChecker.query(left, right, threshold));
        }
    }
}
