package org.gd.leetcode.p0460;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-25
 */
class O1CacheProviderFactory implements CacheProviderFactory {

    public static final O1CacheProviderFactory INSTANCE = new O1CacheProviderFactory();

    private O1CacheProviderFactory() {}

    @Override
    public LFUCache.CacheProvider create(int capacity) { return new LFUCache.O1CacheProvider(capacity); }

    @Override
    public String toString() { return "O(1)"; }
}
