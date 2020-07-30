package org.gd.leetcode.p0217;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/contains-duplicate/
 *
 * @author Gorkhover D.
 * @since 2018-11-01
 */
@LeetCode(
        name = "Contains Duplicate",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.FIXME,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.TWO_POINTERS
        }
)
interface Solution {

    boolean containsDuplicate(int[] nums);
}
