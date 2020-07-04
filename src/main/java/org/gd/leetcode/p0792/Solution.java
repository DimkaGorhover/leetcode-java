package org.gd.leetcode.p0792;

import org.gd.leetcode.common.LeetCode;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 *
 * @see org.gd.leetcode.p0392.Solution
 */
@LeetCode(
        name = "Number of Matching Subsequences",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.ARRAY
)
@SuppressWarnings("JavadocReference")
class Solution {

    private static Map<String, Integer> compact(String[] words) {

        if (words == null || words.length == 0)
            return Collections.emptyMap();

        if (words.length == 1)
            return Collections.singletonMap(words[0], 1);

        HashMap<String, Integer> compact = new LinkedHashMap<>();
        for (String subSequence : words) {
            compact.compute(subSequence, (s, count) -> 1 + (count == null ? 0 : count));
        }
        return compact;
    }

    private boolean isSubsequence(String subSeq, String seq) {

        int subSeqLength = subSeq.length();
        int subSeqIndex = 0;

        int seqLength = seq.length();
        int seqIndex = 0;

        while (subSeqIndex < subSeqLength && seqIndex < seqLength) {

            if (subSeq.charAt(subSeqIndex) == seq.charAt(seqIndex))
                subSeqIndex++;

            seqIndex++;

            if (subSeqIndex == subSeqLength)
                return true;

            if (subSeq.charAt(subSeqLength - 1) == seq.charAt(seqLength - 1))
                subSeqLength--;

            seqLength--;

            if (subSeqIndex == subSeqLength)
                return true;
        }

        return subSeqIndex == subSeqLength;
    }

    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        Map<String, Integer> compact = compact(words);
        for (Map.Entry<String, Integer> entry : compact.entrySet()) {
            if (isSubsequence(entry.getKey(), S))
                count += entry.getValue();
        }

        return count;
    }
}
