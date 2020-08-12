package org.gd.leetcode.p0119;

import org.gd.leetcode.common.LeetCode;

import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0118.Solution
 * @since 2018-12-21
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Pascals Triangle II",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.ARRAY
)
interface Solution {

    List<Integer> getRow(int rowIndex);
}
