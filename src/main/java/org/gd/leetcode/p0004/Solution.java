package org.gd.leetcode.p0004;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * @see org.gd.leetcode.p0295.MedianFinder
 * @since 2019-09-24
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "median of two sorted arrays",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DIVIDE_AND_CONQUER,
                LeetCode.Tags.BINARY_SEARCH,
                LeetCode.Tags.ARRAY
        })
class Solution {

/*
class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n % 2 == 0) {
            return (findKthElement(n / 2, 0, 0, nums1, nums2) + findKthElement(n / 2 + 1, 0, 0, nums1, nums2)) / 2.0;
        }
        return findKthElement(n / 2 + 1, 0, 0, nums1, nums2);
    }

    public int findKthElement(int k, int index1, int index2, int[] nums1, int[] nums2) {
        if (index1 >= nums1.length) {
            return nums2[index2 + k - 1];
        }
        if (index2 >= nums2.length) {
            return nums1[index1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[index1], nums2[index2]);
        }
        int mid1 = index1 + k / 2 - 1 < nums1.length ? nums1[index1 + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = index2 + k / 2 - 1 < nums2.length ? nums2[index2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (mid1 < mid2) {
            return findKthElement(k - k / 2, index1 + k / 2, index2, nums1, nums2);
        }
        return findKthElement(k - k / 2, index1, index2 + k / 2, nums1, nums2);
    }

}
 */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int sumLength = nums1.length + nums2.length;
        int newLength = (sumLength >> 1) + 1;
        int[] ints = new int[newLength];

        int i = 0;
        for (int i1 = 0, i2 = 0; i < newLength; i++) {
            int num1 = i1 < nums1.length ? nums1[i1] : Integer.MAX_VALUE;
            int num2 = i2 < nums2.length ? nums2[i2] : Integer.MAX_VALUE;
            if (num1 < num2) {
                ints[i] = num1;
                i1++;
            } else {
                ints[i] = num2;
                i2++;
            }
        }

        if (sumLength % 2 == 0)
            return (ints[ints.length - 2] + ints[ints.length - 1]) * 0.5;

        return ints[ints.length - 1];
    }
}
