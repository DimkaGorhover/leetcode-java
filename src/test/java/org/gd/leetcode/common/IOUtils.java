package org.gd.leetcode.common;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.var;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-23
 */
@UtilityClass
public final class IOUtils {

    public static BufferedReader resource(@NonNull Class<?> context,
                                          @NonNull String resourceName) {
        var resource = context.getResourceAsStream(resourceName);
        if (resource == null)
            throw new RuntimeException("resource not found");

        return new BufferedReader(new InputStreamReader(resource));
    }
}
