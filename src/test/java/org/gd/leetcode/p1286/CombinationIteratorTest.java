package org.gd.leetcode.p1286;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for {@link CombinationIterator}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-13
 */
@DisplayName("LeetCode #1286: Iterator for Combination")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class CombinationIteratorTest {

    @Test
    @DisplayName("001")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_001() {

        var iterator = new CombinationIterator("abc", 2);

        //@formatter:off
        assertTrue(iterator.hasNext());   assertEquals("ab", iterator.next());
        assertTrue(iterator.hasNext());   assertEquals("ac", iterator.next());
        assertTrue(iterator.hasNext());   assertEquals("bc", iterator.next());

        assertFalse(iterator.hasNext());
        //@formatter:on
    }

    @Test
    @DisplayName("002")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_002() {

        var iterator = new CombinationIterator("ahijp", 2);

        //@formatter:off
        assertTrue(iterator.hasNext());   assertEquals("ah", iterator.next());
        assertTrue(iterator.hasNext());   assertEquals("ai", iterator.next());
        assertTrue(iterator.hasNext());   assertEquals("aj", iterator.next());
        assertTrue(iterator.hasNext());   assertEquals("ap", iterator.next());
        assertTrue(iterator.hasNext());   assertEquals("hi", iterator.next());
        assertTrue(iterator.hasNext());   assertEquals("hj", iterator.next());
        assertTrue(iterator.hasNext());   assertEquals("hp", iterator.next());
        //@formatter:on
    }
}
