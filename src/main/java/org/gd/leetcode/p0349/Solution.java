package org.gd.leetcode.p0349;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-14
 */
@LeetCode(
        name = "Intersection of Two Arrays",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.SORT,
                LeetCode.Tags.TWO_POINTERS
        }
)
interface Solution {

    int[] intersection(int[] nums1, int[] nums2);
}
