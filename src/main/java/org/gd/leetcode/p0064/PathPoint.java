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
        return SimplePathPoint.start(grid);
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
