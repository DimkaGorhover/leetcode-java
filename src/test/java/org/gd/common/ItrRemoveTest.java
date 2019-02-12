package org.gd.common;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Horkhover Dmytro
 * @since 2019-02-01
 */
class ItrRemoveTest {

    @Test
    @DisplayName("Name")
    void test_Name() {
        var list     = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9,10,11));
        var iterable = new FilterIterable<>(list, i -> i % 3 == 0);

        var itr = iterable.iterator();
        assertTrue(itr.hasNext()); assertEquals(3, (int) itr.next());
        assertTrue(itr.hasNext()); assertEquals(6, (int) itr.next());
        assertTrue(itr.hasNext()); assertEquals(9, (int) itr.next());

        assertEquals(List.of(3,6,9), list);
    }

    @RequiredArgsConstructor(access = AccessLevel.PACKAGE)
    static class FilterIterable<T> implements Iterable<T> {

        final Iterable<T>  inner;
        final Predicate<T> filter;

        @Override
        public Iterator<T> iterator() {
            return new Iterator<>() {

                final Iterator<T> itr = inner.iterator();

                T next = null;

                @Override
                public boolean hasNext() {
                    while (next == null && itr.hasNext()) {
                        if (!filter.test(next = itr.next())) {
                            itr.remove();
                            next = null;
                        } else {
                            break;
                        }
                    }
                    return next != null;
                }

                @SuppressWarnings("ResultOfMethodCallIgnored")
                @Override
                public T next() {
                    if (!hasNext())
                        throw new NoSuchElementException();
                    final T next = this.next;
                    this.next = null;
                    hasNext();
                    return next;
                }
            };
        }
    }
}
