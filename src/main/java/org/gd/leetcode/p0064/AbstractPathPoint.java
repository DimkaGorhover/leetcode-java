package org.gd.leetcode.p0064;

import lombok.NonNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

/**
 * @author Horkhover D.
 * @since 2020-07-05
 */
abstract class AbstractPathPoint implements PathPoint {

    protected final int[][] grid;
    protected final int rows, cols;
    protected final int row, col;
    private final int sum;

    protected AbstractPathPoint(@NonNull int[][] grid, @Nullable PathPoint prev, int row, int col) {
        this.grid = grid;
        rows = grid.length;
        cols = rows > 0 ? grid[0].length : 0;

        this.row = row;
        this.col = col;

        this.sum = (prev == null ? 0 : prev.sum()) + grid[row][col];
    }

    @Override
    public int sum() { return sum; }

    @Override
    public boolean isFinish() {
        return row == (rows - 1) && col == (cols - 1);
    }

    @Nonnull
    @Override
    public Optional<PathPoint> down() {
        if (row == rows - 1)
            return Optional.empty();

        return Optional.of(new SimplePathPoint(grid, this, row + 1, col));
    }

    @Nonnull
    @Override
    public Optional<PathPoint> right() {
        if (col == cols - 1)
            return Optional.empty();

        return Optional.of(new SimplePathPoint(grid, this, row, col + 1));
    }
}
