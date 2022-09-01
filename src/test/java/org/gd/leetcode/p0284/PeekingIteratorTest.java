package org.gd.leetcode.p0284;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for {@link PeekingIterator}
 *
 * @since 2019-09-13
 */
class PeekingIteratorTest {

    @Test
    @DisplayName("LeetCode #284: Peeking Iterator")
    void test_Peek() throws Exception {

        PeekingIterator<Integer> iterator = new PeekingIterator<>(Arrays.asList(1, 2, 3, 4, 5).iterator());

        assertTrue(iterator.hasNext());

        assertEquals(1, iterator.peek());
        assertEquals(1, iterator.peek());
        assertEquals(1, iterator.next());

        assertEquals(2, iterator.next());

        assertEquals(3, iterator.peek());
        assertEquals(3, iterator.peek());
        assertEquals(3, iterator.next());

        assertEquals(4, iterator.next());
        assertEquals(5, iterator.next());

        assertFalse(iterator.hasNext());

        assertThrows(NoSuchElementException.class, iterator::next);
        assertThrows(NoSuchElementException.class, iterator::peek);
    }
}