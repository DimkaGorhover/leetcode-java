package org.gd.leetcode.p0307;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.params.provider.Arguments;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Horkhover D.
 * @since 2020-07-14.07.2020
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE, staticName = "of")
class TestCase implements Arguments, Iterable<SubCase> {

    private final int[] nums;
    private final List<SubCase> subCases;

    public int[] nums() { return Arrays.copyOf(nums, nums.length); }

    @Override
    public Object[] get() { return new Object[]{this}; }

    @Nonnull
    @Override
    public Iterator<SubCase> iterator() {
        if (subCases.isEmpty())
            return Collections.emptyIterator();
        return subCases.iterator();
    }

    @Override
    public String toString() {
        return subCases.toString();
    }
}
