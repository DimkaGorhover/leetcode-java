package org.gd.leetcode.p1007;

import org.gd.leetcode.common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 *
 * @author Horkhover Dmytro
 * @since 2020-10-19
 */
@LeetCode(
        name = "Minimum Domino Rotations For Equal Row",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.FIXME,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.GREEDY
        }
)
class Solution {

    private static final BiFunction<Integer, Integer, Integer> INC = (ignore, count) -> 1 + (count == null ? 0 : count);

    public int minDominoRotations(int[] A, int[] B) {

        if (A == null || B == null || A.length != B.length || A.length == 0) {
            return -1;
        }

        Map<Integer, Integer> upMap = new HashMap<>(B.length);
        Map<Integer, Integer> downMap = new HashMap<>(B.length);

        int upMaxCount = 0;
        int downMaxCount = 0;
        int upMaxValue = 0;
        int downMaxValue = 0;
        int count;

        for (int i = 0; i < B.length; i++) {

            count = upMap.compute(A[i], INC);
            if (upMaxCount < count) {
                upMaxCount = count;
                upMaxValue = A[i];
            }

            count = downMap.compute(B[i], INC);
            if (downMaxCount < count) {
                downMaxCount = count;
                downMaxValue = B[i];
            }
        }

        final int targetCount;
        if (upMaxCount > downMaxCount) {
            targetCount = A.length - upMaxCount;
            count = downMap.getOrDefault(upMaxValue, -1);
        } else {
            targetCount = A.length - downMaxCount;
            count = upMap.getOrDefault(downMaxValue, -1);
        }

        if (count >= targetCount) {
            return targetCount;
        }

        return -1;
    }
}
