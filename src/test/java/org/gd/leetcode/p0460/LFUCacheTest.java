package org.gd.leetcode.p0460;

import org.junit.jupiter.api.*;

import lombok.ToString;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link LFUCache};
 *
 * @author Gorkhover D.
 * @see org.gd.leetcode.p0146.LRUCacheTest
 * @since 2018-10-18
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #460: LFU Cache")
class LFUCacheTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new LoggedCacheProviderFactoryWrapper(O1CacheProviderFactory.INSTANCE))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Get #1")
    void test_Get_001(CacheProviderFactory cacheProviderFactory) {

        var cache = cacheProviderFactory.create(2);

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

        for (int i = 0; i < 10; i++) {
            assertEquals(4, cache.get(4));
        }

        cache.get(4);
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
