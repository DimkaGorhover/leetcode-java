package org.gd.common;

import java.util.concurrent.Callable;

/**
 * @since 2020-10-25
 */
public final class Utils {

    private Utils() { throw new UnsupportedOperationException(); }

    public static <T> T get(Callable<T> callable) {
        if (callable == null)
            return null;
        try {
            return callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
