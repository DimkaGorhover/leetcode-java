package org.gd.common;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Horkhover Dmytro
 * @since 2018-12-23
 */
public interface Stack<E> extends Collection<E> {

    boolean push(E element);

    E pop();

    List<E> toList();

    Set<E> toSet();
}
