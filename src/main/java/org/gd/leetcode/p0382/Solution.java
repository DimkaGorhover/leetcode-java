package org.gd.leetcode.p0382;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/linked-list-random-node/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-22
 */
@LeetCode(
        name = "Linked List Random Node",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.RESERVOIR_SAMPLING
        }
)
interface Solution {

    int getRandom();
}
