package org.gd.leetcode.common;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link ListNode}
 *
 * @author Horkhover D.
 * @since 2020-07-01
 */
@SuppressWarnings("deprecation")
class ListNodeTest {

    @Test
    @DisplayName("Copy")
    void test_Copy() {
        ListNode head = ListNode.of(1, 2, 3, 4);
        assertEquals(head, head.copy());
        assertNotSame(head, head.copy());
    }

    @Test
    @DisplayName("Sum")
    void test_Sum() {
        assertEquals(10, ListNode.of(1, 2, 3, 4).sum());
    }

    @Test
    @DisplayName("Count")
    void test_Count() {
        assertEquals(5, ListNode.of(1, 2, 3, 4, 5).count());
    }
}
