package org.gd.leetcode.p0120;

import java.util.List;

class MemoSolution {

    private List<List<Integer>> triangle;
    private int[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0)
            return 0;

        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        int height = (this.triangle = triangle).size();

        List<Integer> lastLine = triangle.get(height - 1);
        int width = lastLine.size();

        memo = new int[height][width];

        return recur(0, 0);
    }

    private int recur(int i, int j) {

        if (i == triangle.size() - 1)
            return triangle.get(i).get(j);

        if (memo[i][j] != 0)
            return memo[i][j];

        int left = recur(i + 1, j);
        int right = recur(i + 1, j + 1);

        int minSum = triangle.get(i).get(j) + Math.min(left, right);

        memo[i][j] = minSum;

        return minSum;
    }
}
