package org.gd.leetcode.p0392;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/is-subsequence/
 */
@LeetCode(
        name = "Is Subsequence",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DYNAMIC_PROGRAMMING,
                LeetCode.Tags.BINARY_SEARCH,
                LeetCode.Tags.GREEDY
        }
)
class Solution {

    public boolean isSubsequence(String subSeq, String seq) {
        final int subSeqLength = subSeq.length();
        int i = 0;
        for (int j = 0, seqLength = seq.length(); i < subSeqLength && j < seqLength; j++) {
            if (subSeq.charAt(i) == seq.charAt(j))
                i++;
        }
        return i == subSeqLength;
    }
}
