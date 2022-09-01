package org.gd.leetcode.common;

import lombok.experimental.UtilityClass;

import java.util.concurrent.Callable;

/**
 * @since 2020-10-25
 */
@UtilityClass
public final class Utils {

    public static <T> T get(Callable<T> callable) {
        if (callable == null)
            return null;
        try {
            return callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void run(SafeRunnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }
}
