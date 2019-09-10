package org.gd.leetcode.p0080;

import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * @since 2019-09-10
 */
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.TWO_POINTERS
        })
class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        n = Math.max(n, nums2.length);
        for (int i = 0; i < n; i++, m++) {

            int pos = Arrays.binarySearch(nums1, 0, m, nums2[i]);
            if (pos < 0)
                pos = -pos - 1;

            int length = m - pos;
            if (length > 0)
                System.arraycopy(nums1, pos, nums1, pos + 1, length);

            nums1[pos] = nums2[i];
        }
    }
}
