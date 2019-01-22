package org.gd.common;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Horkhover Dmytro
 * @since 2019-01-22
 */
interface ICollection<E> extends Collection<E> {

    /**
     * @return instance of {@link List}
     */
    default List<E> toList() { return List.copyOf(this); }

    /**
     * @return instance of {@link Set}
     */
    default Set<E> toSet() { return new HashSet<>(this); }
}
