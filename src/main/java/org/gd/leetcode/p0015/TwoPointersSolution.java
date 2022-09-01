package org.gd.leetcode.p0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class TwoPointersSolution implements Solution {

    private int[] nums;
    private List<List<Integer>> result;

    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2] == 0
                    ? Collections.singletonList(Arrays.asList(nums[0], nums[1], nums[2]))
                    : Collections.emptyList();
        }
        Arrays.sort(nums);
        this.nums = nums;
        this.result = new ArrayList<>();

        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }
}
