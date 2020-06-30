package org.gd.common;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link SegmentTree}
 *
 * @since 2019-09-24
 */
class SegmentTreeTest {

    @Test
    @DisplayName("Main")
    void test_Main() {

        SegmentTree tree = new SegmentTree(new int[]{1, 3, 5, 7, 9, 11});

        assertEquals(15, tree.getSum(1, 3));
        assertEquals(9, tree.getSum(0, 2));

        tree.updateValue(1, 10);
        assertEquals(22, tree.getSum(1, 3));

        tree.updateValue(2, 4);
        assertEquals(21, tree.getSum(1, 3));
    }
}
