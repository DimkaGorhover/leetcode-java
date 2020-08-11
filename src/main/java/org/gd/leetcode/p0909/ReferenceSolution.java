package org.gd.leetcode.p0909;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class ReferenceSolution implements Solution {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Map<Integer, Integer> dist = new HashMap<>();
        dist.put(1, 0);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int s = queue.remove();
            if (s == n * n) return dist.get(s);

            for (int s2 = s + 1; s2 <= Math.min(s + 6, n * n); ++s2) {
                int rc = get(s2, n);
                int r = rc / n, c = rc % n;
                int s2Final = board[r][c] == -1 ? s2 : board[r][c];
                if (!dist.containsKey(s2Final)) {
                    dist.put(s2Final, dist.get(s) + 1);
                    queue.add(s2Final);
                }
            }
        }
        return -1;
    }

    public int get(int s, int N) {
        // Given a square num s, return board coordinates (r, c) as r*N + c
        int quot = (s - 1) / N;
        int rem = (s - 1) % N;
        int row = N - 1 - quot;
        int col = row % 2 != N % 2 ? rem : N - 1 - rem;
        return row * N + col;
    }
}
