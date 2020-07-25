package org.gd.leetcode.p0460;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link LFUCache};
 *
 * @author Gorkhover D.
 * @see org.gd.leetcode.p0146.LRUCacheTest
 * @since 2018-10-18
 */
@Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #460: LFU Cache")
class LFUCacheTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of((O1CacheProviderFactory.INSTANCE))
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

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Get #3")
    void test_Get_003(CacheProviderFactory cacheProviderFactory) {

        var cache = cacheProviderFactory.create(2);

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);

        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(2));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Get #4")
    void test_Get_004(CacheProviderFactory cacheProviderFactory) {

        var cache = cacheProviderFactory.create(2);

        cache.put(3, 1);
        cache.put(2, 1);
        cache.put(2, 2);
        cache.put(4, 4);

        assertEquals(2, cache.get(2));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Get #5")
    void test_Get_005(CacheProviderFactory cacheProviderFactory) {

        var cache = cacheProviderFactory.create(2);

        cache.put(2, 1);
        cache.put(3, 2);

        assertEquals(2, cache.get(3));
        assertEquals(1, cache.get(2));

        cache.put(4, 3);

        assertEquals(1, cache.get(2));
        assertEquals(-1, cache.get(3));
        assertEquals(3, cache.get(4));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Test 6")
    void test_Test6(CacheProviderFactory cacheProviderFactory) {

        final int capacity = 100;

        var cache = cacheProviderFactory.create(capacity);
        for (int i = 1; i <= capacity; i++) {
            cache.put(i, i);
        }

        for (int i = 1; i <= capacity; i++) {
            for (int ignore = 1; ignore <= capacity; ignore++) {
                assertEquals(i, cache.get(i));
            }
        }

        for (int i = capacity + 1; i <= capacity << 1; i++) {
            cache.put(i, i);
        }

        assertEquals(-1, cache.get(1));
        assertEquals(capacity << 1, cache.get(capacity << 1));

        for (int i = 2; i <= capacity; i++) {
            assertEquals(i, cache.get(i));
        }
    }
}
