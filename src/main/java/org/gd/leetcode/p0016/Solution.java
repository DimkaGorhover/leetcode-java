package org.gd.leetcode.p0016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * TODO: https://leetcode.com/problems/3sum/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0001.Solution
 * @see org.gd.leetcode.p0015.Solution
 * @see org.gd.leetcode.p0018.Solution
 * @since 2018-12-15
 */
@SuppressWarnings("JavadocReference")
class Solution {

    @SuppressWarnings("Duplicates")
    private static List<Integer> hashTable(
            int[] nums, int fromIndex, int toIndex,
            int target) {
        Integer                   j;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = fromIndex; i < toIndex; i++) {
            if ((j = map.get(target - nums[i])) != null)
                return Arrays.asList(-target, j, nums[i]);
            map.put(nums[i], nums[i]);
        }
        return null;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        List<Integer>       integers;
        List<List<Integer>> all = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++)
            if ((integers = hashTable(nums, i + 1, nums.length, 0 - nums[i])) != null)
                all.add(integers);

            return all;
    }
}
