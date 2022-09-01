package org.gd.leetcode.common;

public interface SafeRunnable extends Runnable {

    void safeRun() throws Exception;

    @Override
    default void run() {
        try {
            safeRun();
        } catch (Exception e) {
            throw new RuntimeException("nested exception", e);
        }
    }
}
