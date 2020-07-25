package org.gd.leetcode.p0146;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link LRUCache}
 *
 * @since 2019-09-18
 */
@DisplayName("LeetCode #146: LRU Cache")
class LRUCacheTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new O1CacheProviderFactory()),
                Arguments.of(new LogN_CacheProviderFactory())
        );
    }

    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("GetAndPut #1")
    void test_GetAndPut_001(CacheProviderFactory cacheProviderFactory) {

        CacheProvider cache = cacheProviderFactory.create(2);

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

    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("GetAndPut #2")
    void test_GetAndPut_002(CacheProviderFactory cacheProviderFactory) {

        CacheProvider cache = cacheProviderFactory.create(2);

        cache.put(2, 1);
        cache.put(2, 2);

        assertEquals(2, cache.get(2));

        cache.put(1, 1);
        cache.put(4, 1);

        assertEquals(-1, cache.get(2));
    }
}