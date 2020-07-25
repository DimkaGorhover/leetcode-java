package org.gd.leetcode.p0460;

class ZeroCapacityCacheProvider implements CacheProvider {

    static final ZeroCapacityCacheProvider INSTANCE = new ZeroCapacityCacheProvider();

    private ZeroCapacityCacheProvider() {
    }

    @Override
    public int get(int key) { return -1; }

    @Override
    public void put(int key, int value) {}

    @Override
    public String toString() { return "[]"; }
}
