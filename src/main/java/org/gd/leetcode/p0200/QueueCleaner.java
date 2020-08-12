package org.gd.leetcode.p0200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Horkhover Dmytro
 * @see Solution
 * @see RecursiveCleaner
 * @since 2020-07-31
 */
class QueueCleaner implements Cleaner {

    private final char[][] grid;
    private final int rows, cols;

    QueueCleaner(char[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
    }

    @Override
    public int clean(int row, int col) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});

        int[] pair;
        int count = 0;
        while ((pair = q.poll()) != null) {

            row = pair[0];
            col = pair[1];

            if (row < 0 || row == rows || col < 0 || col == cols || grid[row][col] == '0')
                continue;

            count++;

            grid[row][col] = '0';

            q.add(new int[]{row, col + 1});
            q.add(new int[]{row, col - 1});

            q.add(new int[]{row + 1, col});
            q.add(new int[]{row - 1, col});
        }

        return count;
    }
}
