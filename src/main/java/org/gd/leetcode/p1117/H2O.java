package org.gd.leetcode.p1117;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/building-h2o/
 */
@LeetCode(
        name = "Building H2O",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.CONCURRENCY
)
interface H2O {

    int MAX_HYDROGEN = 2;
    int MAX_OXYGEN = 1;

    void hydrogen(Runnable releaseHydrogen) throws InterruptedException;

    void oxygen(Runnable releaseOxygen) throws InterruptedException;
}
