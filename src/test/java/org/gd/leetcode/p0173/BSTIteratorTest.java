package org.gd.leetcode.p0173;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link BSTIterator}
 *
 * @since 2019-09-24
 */
@DisplayName("LeetCode #173: Binary Search Tree Iterator")
class BSTIteratorTest {

    @Test
    @DisplayName("Next")
    void test_Next() throws Exception {
        BSTIterator iterator = new BSTIterator(TreeNode.of(7, 3, 15, null, null, 9, 20));
        assertEquals(3, iterator.next());
        assertEquals(7, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(9, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(15, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(20, iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}