package org.gd.leetcode.p1103;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/distribute-candies-to-people/
 * 
 * @author Horkhover Dmytro
 * @since 2020-08-17
 */
@LeetCode(
        name = "Distribute Candies to People",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.MATH
)
class Solution {

    public int[] distributeCandies(int candies, int num_people) {
        int[] arr = new int[num_people];
        for (int i = 0; candies > 0; i++) {
            arr[i % num_people] += Math.min(candies, i + 1);
            candies -= i + 1;
        }
        return arr;
    }
}
