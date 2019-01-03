package org.gd.common;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Horkhover Dmytro
 * @since 2018-12-23
 */
public interface Stack<E> extends Collection<E> {

    boolean push(E element);

    /**
     * @return {@code null} is stack is empty
     *
     * @see #isEmpty()
     */
    E pop();

    /**
     * @return instance of {@link List}
     */
    default List<E> toList() { return List.copyOf(this); }

    /**
     * @return instance of {@link Set}
     */
    default Set<E> toSet() { return new HashSet<>(this); }
}
