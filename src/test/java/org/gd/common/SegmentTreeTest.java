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
    @DisplayName("001")
    void test_001() {
        SegmentTree tree = new SegmentTree(new int[]{1, 2, 3, 4});
        assertEquals(6, tree.getSum(0, 2));

        tree = new SegmentTree(new int[0]);
        tree.getSum(0, 1);
    }

    @Test
    @DisplayName("Main")
    void test_Main() {

        SegmentTree tree = new SegmentTree(new int[]{1, 3, 5, 7, 9, 11});

        assertEquals(15, tree.getSum(1, 3));
        assertEquals(9, tree.getSum(0, 2));

        tree.update(1, 10);
        assertEquals(22, tree.getSum(1, 3));

        tree.update(2, 4);
        assertEquals(21, tree.getSum(1, 3));

        tree = new SegmentTree(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(tree);
    }
}
