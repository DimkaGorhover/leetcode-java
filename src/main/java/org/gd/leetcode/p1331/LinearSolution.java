package org.gd.leetcode.p1331;

/**
 * @see SortSolution
 * @since 2020-11-18
 */
class LinearSolution implements Solution {

    @Override
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0)
            return arr;

        if (arr.length == 1)
            return new int[]{1};

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int number : arr) {
            if (number > max)
                max = number;
            if (number < min)
                min = number;
        }

        int[] table = new int[max - min + 1];
        for (int number : arr)
            table[number - min] = 1;

        for (int i = 1; i < table.length; i++)
            table[i] += table[i - 1];

        int[] rank = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            rank[i] = table[arr[i] - min];

        return rank;
    }
}
