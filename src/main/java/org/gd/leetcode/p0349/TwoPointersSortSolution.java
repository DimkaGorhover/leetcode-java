package org.gd.leetcode.p0349;

import java.util.Arrays;

/**
 * @author Horkhover Dmytro
 * @see HashTableSolution
 * @since 2020-08-14
 * @deprecated too slow solution
 */
@Deprecated
class TwoPointersSortSolution implements Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int i0 = 0, i1 = 0, i2 = 0;

        while (i1 < nums1.length && i2 < nums2.length) {

            int num1 = nums1[i1];
            int num2 = nums2[i2];

            if (num1 == num2) {

                if (i0 == 0 || result[i0 - 1] != num1) {
                    result[i0] = num1;
                    i0++;
                }

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
