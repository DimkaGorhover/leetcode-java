package org.gd.leetcode.p0217;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-30
 */
class HashSetSolution implements Solution {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1)
            return false;

        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }

        return false;
    }
}
