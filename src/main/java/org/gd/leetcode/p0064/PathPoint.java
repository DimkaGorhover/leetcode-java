package org.gd.leetcode.p0064;

import javax.annotation.Nonnull;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

/**
 * @author Horkhover D.
 * @since 2020-07-05
 */
interface PathPoint extends Comparable<PathPoint> {

    static PathPoint start(int[][] grid) {
        requireNonNull(grid, "\"grid\" cannot be null");
        int rows = grid.length;
        int cols = rows > 0 ? grid[0].length : 0;

        if (rows * cols > (1 << 4))
            return SimplePathPoint.start(grid);

        return FullPathPoint.start(grid);
    }

    int sum();

    boolean isFinish();

    @Nonnull
    Optional<PathPoint> down();

    @Nonnull
    Optional<PathPoint> right();

    @Override
    default int compareTo(PathPoint o) {
        return Integer.compare(sum(), o.sum());
    }
}
