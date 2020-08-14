package org.gd.leetcode.p0349;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0350.HashTableSolution
 * @since 2020-08-14
 */
@SuppressWarnings("JavadocReference")
class HashTableSolution implements Solution {

    private static Set<Integer> toSet(int[] arr) {
        HashSet<Integer> set = new HashSet<>(arr.length);
        for (int i : arr)
            set.add(i);
        return set;
    }

    private static int[] toArray(Collection<Integer> collection) {
        int[] arr = new int[collection.size()];
        int i = 0;
        for (Integer integer : collection)
            arr[i++] = integer;
        return arr;
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];

        Set<Integer> set = toSet(nums1);
        set.retainAll(toSet(nums2));
        return toArray(set);
    }
}
