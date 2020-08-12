package org.gd.leetcode.p0881;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/boats-to-save-people/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-12
 */
@LeetCode(
        name = "Boats to Save People",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.TWO_POINTERS,
                LeetCode.Tags.GREEDY,
                LeetCode.Tags.HEAP
        }
)
interface Solution {

    int numRescueBoats(int[] people, int limit);
}
