package org.gd.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Gorkhover D.
 * @since 2018-11-02
 */
public final class CollectionUtils {

    private CollectionUtils() {
        throw new UnsupportedOperationException();
    }

    public static List<Integer> toList(int[] ints) {
        return Arrays.stream(ints)
                .boxed()
                .collect(Collectors.toList());
    }
}
