package org.gd.leetcode.p0442;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-30
 */
@LeetCode(
        name = "Find All Duplicates in an Array",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY
        }
)
class Solution {

    public List<Integer> findDuplicates(int[] nums) {

        if (nums == null || nums.length <= 0)
            return Collections.emptyList();

        if (nums.length == 2)
            return nums[0] == nums[1] ? Collections.singletonList(nums[0]) : Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] < 0) {
                result.add(num);
            } else {
                nums[num - 1] = -nums[num - 1];
            }
        }
        return result;
    }
}
