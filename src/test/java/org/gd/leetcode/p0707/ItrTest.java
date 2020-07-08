package org.gd.leetcode.p0707;

import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ItrTest {

    @Test
    void test() {
        var itr = new Itr(new Node(1));
        assertTrue(itr.hasNext());
        assertEquals(1, itr.next());
        assertFalse(itr.hasNext());
        assertThrows(NoSuchElementException.class, itr::next);
    }
}