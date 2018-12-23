package org.gd.common;

/**
 * @author Horkhover Dmytro
 * @since 2018-12-23
 */
public interface Stack<E> {

    boolean push(E element);

    E pop();
}
