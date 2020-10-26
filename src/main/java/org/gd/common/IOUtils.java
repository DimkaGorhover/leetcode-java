package org.gd.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.util.Objects.requireNonNull;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-23
 */
public final class IOUtils {

    private IOUtils() { throw new UnsupportedOperationException(); }

    public static BufferedReader resource(Class<?> context, String resourceName) {
        requireNonNull(context, "\"context\" cannot be null");
        requireNonNull(resourceName, "\"resourceName\" cannot be null");

        InputStream resource = context.getResourceAsStream(resourceName);
        if (resource == null)
            throw new RuntimeException("resource not found");

        return new BufferedReader(new InputStreamReader(resource));
    }
}
