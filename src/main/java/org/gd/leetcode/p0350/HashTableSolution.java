package org.gd.leetcode.p0350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0349.HashTableSolution
 * @since 2020-08-14
 */
@SuppressWarnings("JavadocReference")
class HashTableSolution implements Solution {

    /**
     * {@inheritDoc}
     *
     * @param nums1 smaller array
     * @param nums2 bigger array
     *
     * @return intersection
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];

        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);

        int[] result = new int[nums1.length];
        int i = 0;

        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int num : nums1)
            map.compute(num, (ignored, c) -> 1 + (c == null ? 0 : c));

        for (int num : nums2) {
            Integer q = map.computeIfPresent(num, (key, c) -> (c - 1));
            if (q != null && q >= 0)
                result[i++] = num;
        }

        if (i < result.length)
            return Arrays.copyOf(result, i);

        return result;
    }
}
