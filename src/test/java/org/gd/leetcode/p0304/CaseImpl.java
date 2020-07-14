package org.gd.leetcode.p0304;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

/**
 * @since 2019-10-07
 */
class CaseImpl implements Case {

    private final int[][] matrix;
    private final Collection<SubCase> subCases;

    CaseImpl(int[][] matrix, Collection<SubCase> subCases) {
        this.matrix = requireNonNull(matrix, "\"nums\" cannot be null");
        this.subCases = requireNonNull(subCases, "\"subCases\" cannot be null");
    }

    @Override
    public int[][] matrix() { return matrix; }

    @Nonnull
    @Override
    public Iterator<SubCase> iterator() { return subCases.iterator(); }

    @Override
    public Stream<SubCase> stream() { return subCases.stream(); }
}
