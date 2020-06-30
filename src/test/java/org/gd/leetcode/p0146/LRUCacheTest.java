package org.gd.leetcode.p0146;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link LRUCache}
 *
 * @since 2019-09-18
 */
class LRUCacheTest {

    @Test
    @DisplayName("GetAndPut #1")
    void test_GetAndPut_001() throws Exception {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        assertEquals(1, cache.get(1));

        cache.put(3, 3);

        assertEquals(-1, cache.get(2));

        cache.put(4, 4);

        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    @DisplayName("GetAndPut #2")
    void test_GetAndPut_002() throws Exception {

        LRUCache cache = new LRUCache(2);

        cache.put(2, 1);
        cache.put(2, 2);

        assertEquals(2, cache.get(2));

        cache.put(1, 1);
        cache.put(4, 1);

        assertEquals(-1, cache.get(2));
    }
}