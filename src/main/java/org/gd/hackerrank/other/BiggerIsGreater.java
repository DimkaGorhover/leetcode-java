package org.gd.hackerrank.other;

import org.gd.common.Repeat;
import org.gd.hackerrank.common.HackerRank;

/**
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 *
 * https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 *
 * @since 2019-09-23
 */
@Repeat
@HackerRank(difficulty = HackerRank.Level.MEDIUM)
class BiggerIsGreater {

    private BiggerIsGreater() { throw new UnsupportedOperationException(); }

    private static void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    static String biggerIsGreater(String w) {
        char[] array = w.toCharArray();

        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;

        if (i <= 0)
            return "no answer";

        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;

        swap(array, i - 1, j);

        j = array.length - 1;
        while (i < j)
            swap(array, i++, j--);

        return new String(array);
    }
}
