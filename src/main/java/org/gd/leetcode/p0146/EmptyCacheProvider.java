package org.gd.leetcode.p0146;

class EmptyCacheProvider implements CacheProvider {

    static final EmptyCacheProvider INSTANCE = new EmptyCacheProvider();

    private EmptyCacheProvider() {}

    @Override
    public int get(int key) { return -1; }

    @Override
    public void put(int key, int value) {}

    @Override
    public String toString() { return "[]"; }
}
