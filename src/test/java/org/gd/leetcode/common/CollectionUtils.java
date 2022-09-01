package org.gd.leetcode.common;

import lombok.experimental.UtilityClass;
import lombok.var;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Collections.unmodifiableList;
import static java.util.Objects.requireNonNull;

/**
 * @author Gorkhover D.
 * @see Arrays
 * @see Collections
 * @since 2018-11-02
 */
@UtilityClass
public final class CollectionUtils {

    public static <T> Stream<T> stream(Iterator<T> iterator) {
        if (iterator == null || !iterator.hasNext())
            return Stream.empty();

        var spliterator = Spliterators.spliteratorUnknownSize(iterator, 0);
        return StreamSupport.stream(spliterator, false);
    }

    @Deprecated
    public static <T extends Comparable<T>> List<T> sortedListOf() {
        return Collections.emptyList();
    }

    public static <T> List<T> sortedListOf(T value) {
        requireNonNull(value, "\"value\" cannot be null");
        return Collections.singletonList(value);
    }

    public static <T extends Comparable<T>> List<T> sortedListOf(T v1, T v2) {
        requireNonNull(v1, "\"v1\" cannot be null");
        requireNonNull(v2, "\"v2\" cannot be null");
        if (v1.compareTo(v2) > 0) {
            T t = v1;
            v1 = v2;
            v2 = t;
        }
        return Arrays.asList(v1, v2);
    }

    @SafeVarargs
    public static <T extends Comparable<T>> List<T> sortedListOf(T... values) {
        if (values == null || values.length == 0)
            return Collections.emptyList();
        if (values.length == 1)
            return Collections.singletonList(values[0]);
        Arrays.sort(values, Comparator.naturalOrder());
        ArrayList<T> list = new ArrayList<>(values.length);
        Collections.addAll(list, values);
        return Collections.unmodifiableList(list);
    }

    public static <T extends Comparable<T>> List<T> sortedListOf(Iterable<T> iterable) {
        if (iterable == null)
            return Collections.emptyList();
        return sortedListOf(iterable, -1);
    }

    public static <T extends Comparable<T>> List<T> sortedListOf(Collection<T> collection) {
        if (collection == null || collection.isEmpty())
            return Collections.emptyList();
        return sortedListOf(collection, collection.size());
    }

    public static <T extends Comparable<T>> List<T> sortedListOf(Iterable<T> iterable, int size) {
        if (iterable == null)
            return Collections.emptyList();
        ArrayList<T> list = new ArrayList<>(size > 0 ? size : 1 << 4);
        for (T t : iterable)
            list.add(t);
        list.sort(Comparator.naturalOrder());
        return Collections.unmodifiableList(list);
    }

    @SafeVarargs
    public static <T> List<T> listOf(T... value) {
        return Arrays.asList(value);
    }

    public static <T> List<T> listOf(Iterator<T> iterator) {

        if (iterator == null || !iterator.hasNext())
            return Collections.emptyList();

        List<T> list = new ArrayList<>();
        while (iterator.hasNext())
            list.add(iterator.next());

        return Collections.unmodifiableList(list);
    }

    @SafeVarargs
    public static <T> Set<T> setOf(T... values) {
        if (values == null) {
            return Collections.emptySet();
        }
        if (values.length == 1) {
            return Collections.singleton(values[0]);
        }
        return Collections.unmodifiableSet(new LinkedHashSet<>(Arrays.asList(values)));
    }

    public static List<Integer> listOf(int[] ints) {
        if (ints == null) {
            return Collections.emptyList();
        }
        final ArrayList<Integer> list = new ArrayList<>(ints.length);
        for (int i : ints) {
            list.add(i);
        }
        return unmodifiableList(list);
    }

    public static List<List<Integer>> listOf(int[][] ints) {
        if (ints == null) {
            return Collections.emptyList();
        }
        return Arrays.stream(ints)
                .map(innerInts -> Arrays.stream(innerInts).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
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
