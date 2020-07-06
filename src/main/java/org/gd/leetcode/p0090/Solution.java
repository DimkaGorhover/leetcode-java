package org.gd.leetcode.p0090;

import org.gd.leetcode.common.LeetCode;

import java.util.Collections;
import java.util.List;

/**
 * TODO: https://leetcode.com/problems/subsets-ii/
 *
 * @author Horkhover Dmytro
 * @since 2019-02-12
 */
@LeetCode(
        name = "Subsets II",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.BACKTRACKING
        })
class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.singletonList(Collections.emptyList());

        throw new UnsupportedOperationException();
    }
}
