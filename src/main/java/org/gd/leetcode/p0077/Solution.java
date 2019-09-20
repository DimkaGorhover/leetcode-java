package org.gd.leetcode.p0077;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 *
 * @see org.gd.leetcode.p0046.Solution
 * @since 2019-09-20
 */
@SuppressWarnings({"JavadocReference", "DuplicatedCode"})
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = LeetCode.Tags.BACKTRACKING)
class Solution {

    private static final long[] FACT = {
            1, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L, 3628800L,
            39916800L, 479001600L, 6227020800L, 87178291200L, 1307674368000L,
            20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L
    };

    private static Aggregator combine(Aggregator aggregator, Integer[] heap, int from, int to, int index, int k) {

        if (index == k)
            return aggregator.add(heap);

        for (int i = from; i <= to; i++) {
            heap[index] = i;
            combine(aggregator, heap, i + 1, to, index + 1, k);
        }
        return aggregator;
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n < k)
            return Collections.emptyList();

        final Aggregator aggregator = n < FACT.length
                ? new ArrayAggregator(Math.toIntExact(FACT[n] / FACT[n - k] / FACT[k]))
                : new ListAggregator();

        return combine(aggregator, new Integer[k], 1, n, 0, k).sum();
    }

    interface Aggregator {

        Aggregator add(Integer[] arr);

        List<List<Integer>> sum();
    }

    static class ListAggregator implements Aggregator {

        private final List<List<Integer>> list = new ArrayList<>();

        @Override
        public Aggregator add(Integer[] arr) {
            if (arr == null)
                return this;
            if (arr.length == 0) {
                list.add(Collections.emptyList());
                return this;
            }
            Integer[] newArr = new Integer[arr.length];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            list.add(Arrays.asList(newArr));
            return this;
        }

        @Override
        public List<List<Integer>> sum() { return list; }
    }

    static class ArrayAggregator implements Aggregator {

        private final List[] sum;
        private int index = 0;

        ArrayAggregator(int count) { this.sum = new List[count]; }

        @Override
        public Aggregator add(Integer[] arr) {
            if (arr == null)
                return this;
            if (arr.length == 0) {
                sum[index++] = Collections.emptyList();
                return this;
            }
            Integer[] newArr = new Integer[arr.length];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            sum[index++] = Arrays.asList(newArr);
            return this;
        }

        @SuppressWarnings("unchecked")
        @Override
        public List<List<Integer>> sum() { return Arrays.asList(sum); }
    }
}
