package org.gd.leetcode.p0274;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/h-index/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-11
 */
@LeetCode(
        name = "H-Index",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.SORT
        }
)
class Solution {

    public int hIndex(int[] citations) {

        int len = citations.length;
        int[] count = new int[len + 1];

        for (int c : citations)
            count[Math.min(c, len)]++;

        int total = 0;
        for (int i = len; i >= 0; i--)
            if ((total += count[i]) >= i)
                return i;

        return 0;
    }
}
