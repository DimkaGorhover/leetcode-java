package org.gd.leetcode.p0064;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * @author Horkhover D.
 * @since 2020-07-05
 */
class FullPathPoint extends AbstractPathPoint {

    private final FullPathPoint prev;

    FullPathPoint(int[][] grid, FullPathPoint prev, int row, int col) {
        super(grid, prev, row, col);
        this.prev = prev;
    }

    static FullPathPoint start(int[][] grid) {
        return new FullPathPoint(grid, null, 0, 0);
    }

    @Nonnull
    @Override
    public Optional<PathPoint> down() {
        if (row == rows - 1)
            return Optional.empty();

        return Optional.of(new FullPathPoint(grid, this, row + 1, col));
    }

    @Nonnull
    @Override
    public Optional<PathPoint> right() {
        if (col == cols - 1)
            return Optional.empty();

        return Optional.of(new FullPathPoint(grid, this, row, col + 1));
    }

    private String coordinates() {
        return String.format("(%d;%d)", row, col);
    }

    private String path() {
        String path = coordinates();
        if (prev != null)
            path = prev.path() + "->" + path;
        return path;
    }

    @Override
    public String toString() {
        return path() + "=>" + sum();
    }
}
