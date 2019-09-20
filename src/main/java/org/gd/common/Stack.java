package org.gd.common;

/**
 * @author Horkhover Dmytro
 * @see java.util.Stack
 * @since 2018-12-23
 */
public interface Stack<E> extends ICollection<E> {

    default boolean push(E element) { return add(element); }

    /**
     * @return {@code null} is stack is empty
     *
     * @see #isEmpty()
     */
    E pop();
}
