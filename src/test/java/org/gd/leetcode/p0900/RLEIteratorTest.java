package org.gd.leetcode.p0900;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link RLEIterator}.
 *
 * @author Horkhover Dmytro
 * @see RLEIterator
 * @since 2023-04-18
 */
@DisplayName("LeetCode #900: RLE Iterator")
class RLEIteratorTest {

    @Test
    @SneakyThrows
    void test_name() {
        RLEIterator itr = new RLEIterator(new int[]{3, 8, 0, 9, 2, 5});
        assertEquals(8, itr.next(2));
        assertEquals(8, itr.next(1));
        assertEquals(5, itr.next(1));
        assertEquals(-1, itr.next(2));
    }
}
