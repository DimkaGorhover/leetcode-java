package org.gd.leetcode.p0146;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-25
 */
class O1CacheProviderFactory implements CacheProviderFactory {

    @Override
    public CacheProvider create(int capacity) {
        return new O1CacheProvider(capacity);
    }

    @Override
    public String toString() {
        return "O(1)";
    }
}
