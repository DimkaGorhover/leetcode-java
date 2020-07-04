package org.gd.leetcode.p0047;

import org.gd.leetcode.common.LeetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations-ii/
 *
 * @see org.gd.leetcode.p0046.Solution
 */
@SuppressWarnings({"JavadocReference", "DuplicatedCode", "ConstantConditions"})
@LeetCode(
        name = "Permutations II",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = LeetCode.Tags.BACKTRACKING)
class Solution {

    private Set<List<Integer>> result;
    private int length;
    private ArrayList<Integer> item;
    private Queue<Integer> queue;

    private static List<List<Integer>> oneElement(int[] nums) {
        return Collections.singletonList(
                Collections.singletonList(nums[0])
        );
    }

    private static List<List<Integer>> twoElement(int[] nums) {

        if (nums[0] == nums[1]) {
            return Collections.singletonList(
                    Arrays.asList(nums[0], nums[1])
            );
        }

        return Arrays.asList(
                Arrays.asList(nums[0], nums[1]),
                Arrays.asList(nums[1], nums[0])
        );
    }

    private void permute(int index) {
        int num;
        if (index == item.size() - 1) {
            item.set(index, num = queue.poll());
            result.add(new ArrayList<>(item));
            queue.offer(num);
            return;
        }
        for (int i = index; i < length; i++) {
            item.set(index, num = queue.poll());
            permute(index + 1);
            queue.offer(num);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        if (nums == null || nums.length == 0) return Collections.emptyList();
        if (nums.length == 1) return oneElement(nums);
        if (nums.length == 2) return twoElement(nums);

        result = new HashSet<>();
        queue = new LinkedList<>();
        item = new ArrayList<>(length = nums.length);

        for (int num : nums) {
            queue.add(num);
            item.add(0);
        }

        permute(0);

        return new ArrayList<>(result);
    }
}
