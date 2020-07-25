package org.gd.leetcode.p0460;

import org.junit.jupiter.api.*;

import lombok.ToString;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link LFUCache};
 *
 * @author Gorkhover D.
 * @since 2018-10-18
 */
class LFUCacheTest {

    @Test
    @DisplayName("Get #1")
    void test_Get_001() {

        var cache = new O1CacheProvider(2);

        cache.put(1, 1);
        cache.put(2, 2);
        
        assertEquals(1, cache.get(1));
        
        cache.put(3, 3);    // evicts key 2
        
        assertEquals(-1, cache.get(2));
        assertEquals(3, cache.get(3));
        
        cache.put(4, 4);    // evicts key 1.
        
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    @DisplayName("Get #2")
    void test_Get_002() {

        var cache = new LFUCache(0);
        cache.put(0, 0);
        assertEquals(-1, cache.get(0));
    }

    @Test
    @DisplayName("Get #3")
    void test_Get_003() {

        var cache = new LFUCache(2);
        
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);

        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(2));
    }

    @Test
    @DisplayName("Get #4")
    void test_Get_004() {

        var cache = new LFUCache(2);
        
        cache.put(3, 1);
        cache.put(2, 1);
        cache.put(2, 2);
        cache.put(4, 4);

        assertEquals(2, cache.get(2));
    }

    @Test
    @DisplayName("Get #5")
    void test_Get_005() {

        var cache = new LFUCache(2);
        
        cache.put(2, 1);
        cache.put(3, 2);

        assertEquals(2, cache.get(3));
        assertEquals(1, cache.get(2));
        
        cache.put(4, 3);
        
        assertEquals(1, cache.get(2));
        assertEquals(-1, cache.get(3));
        assertEquals(3, cache.get(4));
    }
}
