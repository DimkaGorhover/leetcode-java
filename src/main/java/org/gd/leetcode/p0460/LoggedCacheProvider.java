package org.gd.leetcode.p0460;

class LoggedCacheProvider implements CacheProvider {

    private final CacheProvider provider;

    LoggedCacheProvider(CacheProvider provider) {
        this.provider = provider;
    }

    @Override
    public int get(int key) {

        int value = provider.get(key);

        System.out.println();
        System.out.printf("[%s]: get: %d --> %d%n", provider.getClass().getSimpleName(), key, value);

        return value;
    }

    @Override
    public void put(int key, int value) {

        System.out.println();
        System.out.printf("[%s]: put: %d --> %d%n", provider.getClass().getSimpleName(), key, value);
        System.out.printf("[%s]: before: %s%n", provider.getClass().getSimpleName(), provider);

        provider.put(key, value);

        System.out.printf("[%s]: after: %s%n", provider.getClass().getSimpleName(), provider);
    }

}
