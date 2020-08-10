package org.gd.leetcode.p0692;

import org.gd.leetcode.common.LeetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0347.Solution
 * @see org.gd.leetcode.p0973.Solution
 * @since 2020-08-09
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Top K Frequent Words",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.HEAP,
                LeetCode.Tags.TRIE
        }
)
class Solution implements Comparator<String> {

    private Map<String, Integer> counts;

    public List<String> topKFrequent(String[] words, int k) {
        counts = new HashMap<>();

        ArrayList<String> full = new ArrayList<>(words.length);
        for (String word : words)
            if (counts.compute(word, (w, c) -> 1 + (c == null ? 0 : c)) == 1)
                full.add(word);

        full.sort(this);
        return full.subList(0, k);
    }

    @Override
    public int compare(String o1, String o2) {
        int c1 = counts.getOrDefault(o1, 0);
        int c2 = counts.getOrDefault(o2, 0);
        int compare = Integer.compare(c2, c1);
        return compare != 0 ? compare : o1.compareTo(o2);
    }
}
