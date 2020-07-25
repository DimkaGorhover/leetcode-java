package org.gd.leetcode.p0460;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-25
 */
interface CacheProviderFactory {

    LFUCache.CacheProvider create(final int capacity);
}
