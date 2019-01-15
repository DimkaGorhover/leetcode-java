package org.gd.common;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.util.Objects.requireNonNull;

/**
 * @author Horkhover Dmytro
 * @since 2019-01-14
 */
public class ConcatIterable<T> implements Iterable<T> {

    private final Iterable<T>[] iterables;

    @SafeVarargs
    public ConcatIterable(Iterable<T>... iterables) {
        this.iterables = requireNonNull(iterables, "iterables");
        for (int i = 0; i < iterables.length; i++)
            if (iterables[i] == null)
                iterables[i] = Collections::emptyIterator;
    }

    @Override
    public Iterator<T> iterator() {
        return new ConcatIterator<>(iterables);
    }

    static class ConcatIterator<T> implements Iterator<T> {

        private final Iterable<T>[] iterables;

        private int         i       = 0;
        private Iterator<T> current = null;

        ConcatIterator(Iterable<T>[] iterables) { this.iterables = iterables; }

        @Override
        public boolean hasNext() {
            while (i < iterables.length) {
                if (current == null)
                    current = iterables[i].iterator();
                if (current.hasNext())
                    return true;
                i++;
                current = null;
            }
            return false;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return current.next();
        }

        @Override
        public void remove() {
            if (!hasNext())
                throw new NoSuchElementException();
            current.remove();
        }
    }
}
