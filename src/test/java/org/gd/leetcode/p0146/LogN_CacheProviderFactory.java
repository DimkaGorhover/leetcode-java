package org.gd.leetcode.p0146;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-25
 */
class LogN_CacheProviderFactory implements CacheProviderFactory {

    @Override
    public CacheProvider create(int capacity) {
        return new Log_N_CacheProvider(capacity);
    }

    @Override
    public String toString() {
        return "O(log(n))";
    }
}
