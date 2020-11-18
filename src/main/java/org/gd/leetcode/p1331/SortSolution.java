package org.gd.leetcode.p1331;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author Horkhover Dmytro
 * @see LinearSolution
 * @since 2020-11-18
 */
class SortSolution implements Solution {

    private static Map<Integer, Integer> createRanks(int[] arr) {

        int[] ints = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(ints);

        Map<Integer, Integer> ranksMap = new HashMap<>(arr.length);
        RankFunction rankFunction = new RankFunction();
        for (int number : ints)
            ranksMap.compute(number, rankFunction);

        return ranksMap;
    }

    @Override
    public int[] arrayRankTransform(int[] arr) {

        if (arr == null || arr.length == 0)
            return arr;

        if (arr.length == 1)
            return new int[]{1};

        if (arr.length == 2) {

            if (arr[0] == arr[1])
                return new int[]{1, 1};

            if (arr[0] < arr[1])
                return new int[]{1, 2};

            return new int[]{2, 1};
        }

        Map<Integer, Integer> ranks = createRanks(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ranks.get(arr[i]);
        }

        return arr;
    }


    static class RankFunction implements BiFunction<Integer, Integer, Integer> {

        int rank = 0;

        @Override
        public Integer apply(Integer ignore, Integer prev) {
            return prev == null ? ++rank : prev;
        }
    }
}
