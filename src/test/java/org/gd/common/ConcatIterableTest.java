package org.gd.common;

import org.junit.jupiter.api.*;

import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link ConcatIterable};
 *
 * @author Horkhover Dmytro
 * @since 2019-01-15
 */
class ConcatIterableTest {

    @Test
    void iterator() {

        Iterable<Integer> iterable = new ConcatIterable<>(asList(1, 2, 3), null, asList(4, 5, 6), null);
        iterable = new ConcatIterable<>(iterable, null, asList(7, 8, 9));

        assertEquals(
                IntStream.rangeClosed(1, 9).boxed().collect(toList()),
                StreamSupport.stream(iterable.spliterator(), false).collect(toList())
        );
    }
}