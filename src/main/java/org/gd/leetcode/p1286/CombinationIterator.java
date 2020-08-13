package org.gd.leetcode.p1286;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/problems/iterator-for-combination/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-13
 */
@LeetCode(
        name = "Iterator for Combination",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DESIGN,
                LeetCode.Tags.BACKTRACKING
        }
)
class CombinationIterator {

    private static final long[] F = {
            1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L,
            362880L, 3628800L, 39916800L, 479001600L,
            6227020800L, 87178291200L, 1307674368000L};

    private final List<String> list;
    private final Iterator<String> iterator;
    private final int swSize;
    private final char[] buffer;
    private final String characters;

    @SuppressWarnings("UnnecessaryLocalVariable")
    public CombinationIterator(String characters, final int combinationLength) {

        if (characters == null)
            throw new NullPointerException();

        if (characters.length() > 15)
            throw new IllegalArgumentException();

        if (combinationLength > 15)
            throw new IllegalArgumentException();

        final int n = characters.length();
        final int m = combinationLength;

        final int count = Math.toIntExact(F[n] / (F[n - m] * F[m]));

        list = new ArrayList<>(count);
        swSize = n + 1 - m;
        buffer = new char[m];
        this.characters = characters;

        iterator = traverse(0, 0).iterator();
    }

    private List<String> traverse(int pos, int start) {

        if (pos == buffer.length) {
            list.add(new String(buffer));
            return list;
        }

        final int to = Math.min(start + swSize, characters.length());

        for (int i = start; i < to; i++) {

            char c = characters.charAt(i);
            buffer[pos] = c;
            traverse(pos + 1, i + 1);

        }

        return list;
    }

    public String next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }
}
