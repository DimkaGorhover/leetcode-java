package org.gd.leetcode.p0307;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.gd.leetcode.common.SegmentTree;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Horkhover D.
 * @since 2020-07-14
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE, staticName = "of")
class SumSubCases implements SubCase {

    final int leftBound, rightBound, expected;

    @Override
    public void doAssert(NumArray numArray) {
        assertEquals(expected, numArray.sumRange(leftBound, rightBound));
    }

    @Override
    public void doAssert(SegmentTree st) throws AssertionError {
        assertEquals(expected, st.getSum(leftBound, rightBound));
    }

    @Override
    public String toString() {
        return "Sum{(" + leftBound + "; " + rightBound + ") => " + expected + '}';
    }
}
