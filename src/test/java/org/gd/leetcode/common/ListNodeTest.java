package org.gd.leetcode.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test for {@link ListNode}
 *
 * @author Horkhover D.
 * @since 2020-07-01
 */
@SuppressWarnings("deprecation")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class ListNodeTest {

    @Test
    @DisplayName("concat")
    void test_concat() {

        assertEquals(
                ListNode.rangeClosed(1, 12),
                ListNode.concat(
                        ListNode.rangeClosed(1, 6),
                        ListNode.rangeClosed(7, 12))
        );

        assertEquals(
                ListNode.rangeClosed(1, 12),
                ListNode.concat(
                        ListNode.rangeClosed(1, 3),
                        ListNode.rangeClosed(4, 6),
                        ListNode.rangeClosed(7, 9),
                        ListNode.rangeClosed(10, 12))
        );
    }

    @Test
    @DisplayName("unsafeToString")
    void test_unsafeToString() {

        assertEquals("(1)", ListNode.of(1).unsafeToString());
        assertEquals("(1)=>(2)", ListNode.of(1, 2).unsafeToString());
        assertEquals("(1)=>(2)=>(3)", ListNode.of(1, 2, 3).unsafeToString());
        assertEquals("(1)=>(2)=>(3)=>(4)", ListNode.of(1, 2, 3, 4).unsafeToString());
        assertEquals("(1)=>(2)=>(3)=>(4)=>(5)", ListNode.rangeClosed(1, 5).unsafeToString());
    }

    @Test
    void test_toString() {

        assertEquals("(1)", ListNode.of(1).toString());
        assertEquals("(1)=>(2)", ListNode.of(1, 2).toString());
        assertEquals("(1)=>(2)=>(3)", ListNode.of(1, 2, 3).toString());
        assertEquals("(1)=>(2)=>(3)=>(4)", ListNode.of(1, 2, 3, 4).toString());
        assertEquals("(1)=>(2)=>(3)=>(4)=>(5)", ListNode.rangeClosed(1, 5).toString());

    }

    @Test
    @DisplayName("Copy")
    void test_Copy() {
        ListNode head = ListNode.of(1, 2, 3, 4);
        assertEquals(head, head.copy());
        assertNotSame(head, head.copy());
    }

    @Test
    @DisplayName("HashCode")
    void test_HashCode() {
        assertEquals(
                ListNode.of(1, 2, 3, 4, 5).hashCode(),
                ListNode.of(1, 2, 3, 4, 5).hashCode());
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

    @Test
    @DisplayName("Length")
    void test_Length() {
        int length = ThreadLocalRandom.current().nextInt(5, 100);
        assertEquals(length, ListNode.rangeClosed(1, length).length());
    }

    @Test
    @DisplayName("Iterator")
    void test_Iterator() {
        ListNode node = ListNode.rangeClosed(0, 9);
        Iterator<ListNode> iterator = node.iterator();
        assertThrows(IllegalStateException.class, iterator::remove);
        assertEquals(0, iterator.next().val);
        assertEquals(1, iterator.next().val);
        assertEquals(2, iterator.next().val);
        assertEquals(3, iterator.next().val);
        iterator.remove();
        assertEquals(5, iterator.next().val);
        assertEquals(6, iterator.next().val);
    }
}
