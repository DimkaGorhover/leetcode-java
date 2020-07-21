package org.gd.common;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Collections.unmodifiableList;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toUnmodifiableList;

/**
 * @author Gorkhover D.
 * @see java.util.Arrays
 * @see java.util.Collections
 * @since 2018-11-02
 */
public final class CollectionUtils {

    private CollectionUtils() { throw new UnsupportedOperationException(); }

    public static <T> Stream<T> stream(Iterator<T> iterator) {
        if (iterator == null || !iterator.hasNext())
            return Stream.empty();

        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(iterator, 0), false);
    }

    public static <T> List<T> listOf(Iterator<T> iterator) {

        if (iterator == null || !iterator.hasNext())
            return Collections.emptyList();

        List<T> list = new ArrayList<>();
        while (iterator.hasNext())
            list.add(iterator.next());

        return Collections.unmodifiableList(list);
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
            case 8: return List.of(ints[0], ints[1], ints[2], ints[3], ints[4], ints[5], ints[6], ints[7]);
            case 9: return List.of(ints[0], ints[1], ints[2], ints[3], ints[4], ints[5], ints[6], ints[7], ints[8]);
        }
        final ArrayList<Integer> list = new ArrayList<>(ints.length);
        for (int i : ints)
            list.add(i);
        return unmodifiableList(list);
    }

    public static List<List<Integer>> listOf(int[][] ints) {
        if (ints == null)
            return List.of();
        switch (ints.length) {
            case 0: return List.of();
            case 1: return List.of(listOf(ints[0]));
            case 2: return List.of(listOf(ints[0]), listOf(ints[1]));
            case 3: return List.of(listOf(ints[0]), listOf(ints[1]), listOf(ints[2]));
            case 4: return List.of(listOf(ints[0]), listOf(ints[1]), listOf(ints[2]), listOf(ints[3]));
            case 5: return List.of(listOf(ints[0]), listOf(ints[1]), listOf(ints[2]), listOf(ints[3]), listOf(ints[4]));
            case 6: return List.of(listOf(ints[0]), listOf(ints[1]), listOf(ints[2]), listOf(ints[3]), listOf(ints[4]), listOf(ints[5]));
            case 7: return List.of(listOf(ints[0]), listOf(ints[1]), listOf(ints[2]), listOf(ints[3]), listOf(ints[4]), listOf(ints[5]), listOf(ints[6]));
            case 8: return List.of(listOf(ints[0]), listOf(ints[1]), listOf(ints[2]), listOf(ints[3]), listOf(ints[4]), listOf(ints[5]), listOf(ints[6]), listOf(ints[7]));
            case 9: return List.of(listOf(ints[0]), listOf(ints[1]), listOf(ints[2]), listOf(ints[3]), listOf(ints[4]), listOf(ints[5]), listOf(ints[6]), listOf(ints[7]), listOf(ints[8]));
        }
        return Arrays.stream(ints)
                .map(innerInts -> Arrays.stream(innerInts).boxed().collect(toUnmodifiableList()))
                .collect(toUnmodifiableList());
    }

    public static <T> T last(Iterable<T> collection) {
        requireNonNull(collection, "\"collection\" cannot be null");

        if (collection instanceof Deque)
            return ((Deque<T>) collection).peekLast();

        if (collection instanceof List) {
            List<T> list = (List<T>) collection;
            return (list).get(list.size() - 1);
        }

        if (collection instanceof SortedSet)
            return ((SortedSet<T>) collection).last();

        Iterator<T> iterator = collection.iterator();
        if (iterator.hasNext())
            return iterator.next();

        throw new IllegalArgumentException("collection is empty");
    }
}
