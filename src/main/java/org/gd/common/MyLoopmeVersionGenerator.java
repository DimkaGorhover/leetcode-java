package org.gd.common;

public class MyLoopmeVersionGenerator {

    private MyLoopmeVersionGenerator() { throw new UnsupportedOperationException(); }

    public static String generate(long nowMillis) {
        long intervalMinutes = ((nowMillis / 0xEA60L) - ((0x160AF049000L) / 0xEA60L));
        return (intervalMinutes / 0x2760L) + "." + (intervalMinutes % 0x2760L);
    }
}
