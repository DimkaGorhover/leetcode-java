package org.gd.leetcode.p1424;

import org.gd.leetcode.common.LeetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/diagonal-traverse-ii/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-29
 */
@LeetCode(
        name = "Diagonal Traverse II",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.SORT
        }
)
class Solution {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        if (nums == null || nums.isEmpty())
            return new int[0];

        int row = 0;
        int max = nums.size();
        for (List<Integer> line : nums) {
            max = Math.max(max, row + line.size());
            row++;
        }

        LinkedList<Integer>[] map = new LinkedList[max + 1];

        row = 0;
        int length = 0;
        int maxIndex = -1;
        int index;
        for (List<Integer> line : nums) {
            length += line.size();
            int col = 0;
            for (Integer number : line) {

                maxIndex = Math.max(maxIndex, index = row + col);

                LinkedList<Integer> list = map[index];
                if (list == null)
                    list = map[index] = new LinkedList<>();

                list.addFirst(number);
                col++;
            }

            row++;
        }

        int[] ans = new int[length];
        int i = 0;
        for (int j = 0; j <= maxIndex; j++) {
            LinkedList<Integer> numbers = map[j];
            if (numbers != null) {
                for (Integer number : numbers) {
                    ans[i++] = number;
                }
            }
        }

        return ans;
    }
}
