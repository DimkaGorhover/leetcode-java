package org.gd.hackerrank.other;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link VeryBigSum}
 *
 * @since 2019-09-20
 */
class VeryBigSumTest {

    @Test
    @DisplayName("AVeryBigSum")
    void test_AVeryBigSum() throws Exception {
        long[] arr = {1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
        assertEquals(5000000015L, VeryBigSum.aVeryBigSum(arr));
    }
}