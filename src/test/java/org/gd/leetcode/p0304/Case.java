package org.gd.leetcode.p0304;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * @since 2019-10-07
 */
public interface Case extends Iterable<SubCase>, Arguments {

    int[][] matrix();

    Stream<SubCase> stream();

    @Override
    default Object[] get() { return new Object[]{this}; }
}
