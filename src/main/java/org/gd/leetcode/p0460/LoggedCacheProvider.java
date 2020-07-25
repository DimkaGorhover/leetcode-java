package org.gd.leetcode.p0460;

class LoggedCacheProvider implements LFUCache.CacheProvider {

    private final LFUCache.CacheProvider provider;
    private final String prefix;

    LoggedCacheProvider(LFUCache.CacheProvider provider) {
        this(provider, provider.getClass().getSimpleName());
    }

    LoggedCacheProvider(LFUCache.CacheProvider provider, String prefix) {
        this.provider = provider;
        this.prefix = prefix;
    }

    public static LFUCache.CacheProvider of(LFUCache.CacheProvider cacheProvider) {
        if (cacheProvider instanceof LoggedCacheProvider)
            return cacheProvider;
        return new LoggedCacheProvider(cacheProvider);
    }

    @Override
    public int get(int key) {
        int value = provider.get(key);
        System.out.printf("[ %s ]: get: %d --> %d%n", prefix, key, value);
        return value;
    }

    @Override
    public void put(int key, int value) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("[ %s ]: put: %d --> %d; ", prefix, key, value));
        sb.append(String.format("before: %s; ", provider));

        provider.put(key, value);

        sb.append(String.format("after: %s%n", provider));

        System.out.print(sb);
    }

}
