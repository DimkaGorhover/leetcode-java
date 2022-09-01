package org.gd.leetcode.p0307;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.gd.leetcode.common.SegmentTree;

/**
 * @author Horkhover D.
 * @since 2020-07-14
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE, staticName = "of")
class UpdateSubCases implements SubCase {

    final int i, value;

    @Override
    public void doAssert(NumArray numArray) { numArray.update(i, value); }

    @Override
    public void doAssert(SegmentTree st) { st.update(i, value); }

    @Override
    public String toString() {
        return "Update{" + i + " -> " + value + '}';
    }
}
