package org.gd.leetcode.p0307;

import org.gd.common.SegmentTree;

/**
 * @author Horkhover D.
 * @since 2020-07-14.07.2020
 */
interface SubCase {

    void doAssert(NumArray numArray) throws AssertionError;

    void doAssert(SegmentTree st) throws AssertionError;
}
