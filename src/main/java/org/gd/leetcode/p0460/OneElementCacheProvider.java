package org.gd.leetcode.p0460;

class OneElementCacheProvider implements CacheProvider {

    private boolean init = false;
    private int key, value;

    @Override
    public int get(int key) {
        return init && key == this.key ? value : -1;
    }

    @Override
    public void put(int key, int value) {
        this.key = key;
        this.value = value;
        init = true;
    }

    @Override
    public String toString() {
        if (init)
            return String.format("[%d --> %d]", key, value);
        return "[]";
    }
}
