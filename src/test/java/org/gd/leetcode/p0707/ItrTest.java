package org.gd.leetcode.p0707;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("LeetCode #707: Design Linked List (Iterator Test)")
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