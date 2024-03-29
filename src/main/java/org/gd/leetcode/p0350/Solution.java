package org.gd.leetcode.p0350;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0349.Solution
 * @see org.gd.leetcode.p1002.Solution
 * @since 2020-08-14
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Intersection of Two Arrays II",
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

    int[] intersect(int[] nums1, int[] nums2);
}
