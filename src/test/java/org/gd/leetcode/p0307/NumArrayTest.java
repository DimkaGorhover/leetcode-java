package org.gd.leetcode.p0307;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link NumArray}
 *
 * @since 2019-09-18
 */
class NumArrayTest {

    @Test
    @DisplayName("SumRange")
    void test_SumRange() throws Exception {
        NumArray numArray = new NumArray(new int[]{1, 2, 3, 4});
        assertEquals(6, numArray.sumRange(0, 2));
        numArray.update(0, 3);
        assertEquals(8, numArray.sumRange(0, 2));
    }
}