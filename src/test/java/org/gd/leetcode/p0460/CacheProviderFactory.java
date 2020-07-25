package org.gd.leetcode.p0460;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-25
 */
interface CacheProviderFactory {

    CacheProvider create(final int capacity);
}
