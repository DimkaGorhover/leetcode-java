package org.gd.leetcode.p0350;

import java.util.Arrays;

/**
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0349.TwoPointersSortSolution
 * @since 2020-08-14
 */
@Deprecated
@SuppressWarnings("JavadocReference")
class TwoPointersSortSolution implements Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int i0 = 0, i1 = 0, i2 = 0;

        while (i1 < nums1.length && i2 < nums2.length) {

            int num1 = nums1[i1];
            int num2 = nums2[i2];

            if (num1 == num2) {
                result[i0++] = num1;
                i1++;
                i2++;
            } else if (num1 > num2) {
                i2++;
            } else {
                i1++;
            }
        }

        if (i0 < result.length)
            return Arrays.copyOf(result, i0);

        return result;
    }
}
