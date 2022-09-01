package org.gd.leetcode.p0707;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Test for {@link MyLinkedList}
 */
@DisplayName("LeetCode #707: Design Linked List")
class MyLinkedListTest {

    @Test
    void test_001() {

        var ll = new MyLinkedList();
        ll.addAtHead(1);
        ll.addAtTail(3);
        ll.addAtIndex(1, 2);

        assertEquals(2, ll.get(1));

        ll.deleteAtIndex(1);
        assertEquals(3, ll.get(1));
    }

    @Test
    void test_002() {

        var ll = new MyLinkedList();
        ll.addAtHead(1);
        ll.addAtTail(3);
        ll.addAtIndex(1, 2);

        assertEquals(2, ll.get(1));

        ll.deleteAtIndex(0);
        assertEquals(2, ll.get(0));
    }

    @Test
    void test_003() {

        var ll = new MyLinkedList();
        ll.addAtHead(2);
        ll.deleteAtIndex(1);
        ll.addAtHead(2);
        ll.addAtHead(7);
        ll.addAtHead(3);
        ll.addAtHead(2);
        ll.addAtHead(5);
        ll.addAtTail(5);

        ll.get(5);
        ll.deleteAtIndex(6);
        ll.deleteAtIndex(4);
    }

    @Test
    void test() {
        var ll = IMyLinkedList.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        ll.addAtTail(10);

        List<Integer> expected = IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList());

        assertEquals(ll, expected);
        assertEquals(expected.toString(), ll.toString());

        assertEquals(8, ll.get(8));
        assertEquals(2, ll.get(2));

        ll.deleteAtIndex(5);
        assertEquals(java.util.Arrays.asList(0, 1, 2, 3, 4, 6, 7, 8, 9, 10).toString(), ll.toString());

        ll.deleteAtIndex(0);
        assertEquals(java.util.Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9, 10).toString(), ll.toString());

        ll.deleteAtIndex(ll.size() - 1);
        assertEquals(java.util.Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9).toString(), ll.toString());

        assertEquals(3, ll.get(2));
        assertEquals(9, ll.get(7));

        while (ll.size() > 0)
            ll.deleteAtIndex(0);

        ll.addAtTail(1);
        ll.addAtHead(2);

        assertEquals(java.util.Arrays.asList(2, 1).toString(), ll.toString());

        ll.addAtIndex(1, 3);
        assertEquals(java.util.Arrays.asList(2, 3, 1).toString(), ll.toString());
    }

    @Test
    void test_HashCode() {

        MyLinkedList ll = IMyLinkedList.of();
        assertEquals(java.util.Arrays.asList().hashCode(), ll.hashCode());

        assertEquals(
                java.util.Arrays.asList(1, 2, 3, 4).hashCode(),
                IMyLinkedList.of(1, 2, 3, 4).hashCode()
        );
    }

    @Test
    void test_ToString() {
        assertEquals("[]", IMyLinkedList.of().toString());
        assertEquals("[1]", IMyLinkedList.of(1).toString());
        assertEquals("[1, 2]", IMyLinkedList.of(1, 2).toString());
    }

    @Test
    void test_Equals() {
        assertEquals(IMyLinkedList.of(1, 2, 3, 4), java.util.Arrays.asList(1, 2, 3, 4));
        assertNotEquals(IMyLinkedList.of(1, 2, 3, 4), java.util.Arrays.asList(1, 2, 3, 5));
        assertNotEquals(IMyLinkedList.of(1, 2, 3), java.util.Arrays.asList(1, 2, 3, 4));
        assertNotEquals(IMyLinkedList.of(1, 2, 3, 4), java.util.Arrays.asList(1, 2, 3));
        assertNotEquals(IMyLinkedList.of(1, 2, 3, 4), 1);
    }
}