package org.gd.leetcode.p0070;

import java.util.HashMap;
import java.util.Map;

class MemoizationSolution implements Solution {

    private final Map<Integer, Integer> memo = new HashMap<>();

    MemoizationSolution() {
        memo.put(1, 1);
        memo.put(2, 2);
    }

    public int climbStairs(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        Integer cache = memo.get(n);
        if (cache != null)
            return cache;

        int v1 = climbStairs(n - 2);
        memo.put(n - 2, v1);

        int v0 = climbStairs(n - 1);
        memo.put(n - 1, v0);

        return v0 + v1;
    }
}
