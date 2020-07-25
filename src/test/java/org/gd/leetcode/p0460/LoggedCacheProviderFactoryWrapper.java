package org.gd.leetcode.p0460;

import static java.util.Objects.requireNonNull;

/**
 * @author Horkhover Dmytro
 * @see LoggedCacheProvider
 * @since 2020-07-25
 */
class LoggedCacheProviderFactoryWrapper implements CacheProviderFactory {

    private final CacheProviderFactory cacheProviderFactory;

    LoggedCacheProviderFactoryWrapper(CacheProviderFactory cacheProviderFactory) {
        requireNonNull(cacheProviderFactory, "\"cacheProviderFactory\" cannot be null");
        this.cacheProviderFactory = cacheProviderFactory;
    }

    @Override
    public CacheProvider create(int capacity) {
        CacheProvider cacheProvider = cacheProviderFactory.create(capacity);
        return new LoggedCacheProvider(cacheProvider, toString());
    }

    @Override
    public String toString() {
        return cacheProviderFactory.toString();
    }
}
