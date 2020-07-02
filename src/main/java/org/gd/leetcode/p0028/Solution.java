package org.gd.leetcode.p0028;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/implement-strstr/
 */
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TWO_POINTERS,
                LeetCode.Tags.STRING
        })
class Solution {

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
