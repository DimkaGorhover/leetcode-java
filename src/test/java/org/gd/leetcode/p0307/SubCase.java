package org.gd.leetcode.p0307;

import org.gd.leetcode.common.SegmentTree;

/**
 * @author Horkhover D.
 * @since 2020-07-14
 */
interface SubCase {

    void doAssert(NumArray numArray) throws AssertionError;

    void doAssert(SegmentTree st) throws AssertionError;
}
