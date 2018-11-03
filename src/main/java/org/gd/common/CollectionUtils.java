package org.gd.common;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

/**
 * @author Gorkhover D.
 * @see java.util.Arrays
 * @see java.util.Collections
 * @since 2018-11-02
 */
public final class CollectionUtils {

    private CollectionUtils() {
        throw new UnsupportedOperationException();
    }

    public static List<Integer> listOf(int[] ints) {
        if (ints == null)
            return List.of();
        switch (ints.length) {
            case 0: return List.of();
            case 1: return List.of(ints[0]);
            case 2: return List.of(ints[0], ints[1]);
            case 3: return List.of(ints[0], ints[1], ints[2]);
            case 4: return List.of(ints[0], ints[1], ints[2], ints[3]);
            case 5: return List.of(ints[0], ints[1], ints[2], ints[3], ints[4]);
            case 6: return List.of(ints[0], ints[1], ints[2], ints[3], ints[4], ints[5]);
            case 7: return List.of(ints[0], ints[1], ints[2], ints[3], ints[4], ints[5], ints[6]);
        }
        ArrayList<Integer> list = new ArrayList<>(ints.length);
        for (int i : ints)
            list.add(i);
        return unmodifiableList(list);
    }
}
