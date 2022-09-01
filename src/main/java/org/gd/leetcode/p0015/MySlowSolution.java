package org.gd.leetcode.p0015;

import org.gd.leetcode.common.Repeat;
import org.gd.leetcode.common.LeetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 *
 * @see org.gd.leetcode.p0001.Solution
 * @see org.gd.leetcode.p0018.Solution
 * @since 2019-09-22
 */
@SuppressWarnings("JavadocReference")
@Repeat("3sum too slow")
@LeetCode(
        name = "3sum",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.TWO_POINTERS
        })
class MySlowSolution implements Solution {

    private int[] nums;
    private Set<List<Integer>> cache;
    private List<List<Integer>> result;

    private void add(int v0, int v1, int v2) {
        List<Integer> list = Arrays.asList(v0, v2, v1);
        if (cache.contains(list))
            return;
        result.add(list);
        cache.add(list);
    }

    private void twoSum(int start, int v0) {
        int v1, v2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = start; i < nums.length; i++) {
            v1 = nums[i];
            v2 = -(v0 + v1);
            int pos = map.getOrDefault(v2, -1);
            if (pos >= start) {
                add(v0, v1, v2);
            } else {
                map.put(v1, i);
            }
        }
    }

    @Override
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3)
            return Collections.emptyList();

        if (nums.length == 3) {
            if (nums[0] + nums[1] + nums[2] == 0)
                return Collections.singletonList(Arrays.asList(nums[0], nums[1], nums[2]));

            return Collections.emptyList();
        }

        Arrays.sort(nums);

        this.nums = nums;
        cache = new HashSet<>();
        result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++)
            twoSum(i + 1, nums[i]);

        return result;
    }
}
