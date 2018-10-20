package org.gd.leetcode.p0018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    private static List<List<Integer>> wrap(int[] nums) {
        final ArrayList<Integer> integers = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++)
            integers.add(nums[i]);
        return Collections.singletonList(integers);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length == 4)
            return wrap(nums);


        List<List<Integer>> lists = new ArrayList<>();

        return lists;
    }
}
