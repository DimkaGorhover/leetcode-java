package org.gd.leetcode.p0046;

import org.gd.leetcode.common.LeetCode;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;

/**
 * https://leetcode.com/problems/permutations/
 *
 * @see org.gd.leetcode.p0077.Solution
 * @since 2019-09-20
 */
@SuppressWarnings("JavadocReference")
@LeetCode(difficulty = LeetCode.Level.MEDIUM)
class Solution {

    private List<List<Integer>> result;
    private int length;
    private ArrayList<Integer> item;
    private Deque<Integer> deque;

    private void permute(int index) {
        if (index == length - 1) {
            Integer num = deque.pollFirst();

            requireNonNull(num, "\"num\" cannot be null");

            item.set(index, num);
            deque.add(num);
            return;
        }

        for (int i = index; i < length; i++) {
            Integer num = deque.pollFirst();

            requireNonNull(num, "\"num\" cannot be null");

            item.set(index, num);
            permute(index + 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0)
            return Collections.emptyList();

        if (nums.length == 1) {
            return Collections.singletonList(
                    Collections.singletonList(nums[0])
            );
        }

        if (nums.length == 2) {
            return Arrays.asList(
                    Arrays.asList(nums[0], nums[1]),
                    Arrays.asList(nums[1], nums[0])
            );
        }

        result = new ArrayList<>();
        deque = new LinkedList<>();
        item = new ArrayList<>(length = nums.length);

        for (int num : nums) {
            deque.add(num);
            item.add(0);
        }

        permute(0);

        return result;
    }
}
