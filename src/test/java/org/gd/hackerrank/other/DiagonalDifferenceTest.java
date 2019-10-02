package org.gd.hackerrank.other;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link DiagonalDifference}
 *
 * @since 2019-09-26
 */
class DiagonalDifferenceTest {

    @Test
    @DisplayName("DiagonalDifference")
    void test_DiagonalDifference() throws Exception {

        assertEquals(
                15,
                DiagonalDifference.diagonalDifference(new int[][]{
                        {11, 2, 4},
                        {4, 5, 6},
                        {10, 8, -12}
                }));
    }
}