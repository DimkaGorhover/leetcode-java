package org.gd.leetcode.p0049;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        tags = {
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.STRING
        })
class Solution {

    private static final int[] PRIMES = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
            43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
    };

    private static int hash(String s) {
        int hash = 1;
        for (int i = 0, n = s.length(); i < n; i++)
            hash *= PRIMES[s.charAt(i) - 'a'];
        return hash;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (String s : strs) {
            map.compute(hash(s), (hash, strings) -> {
                if (strings == null)
                    strings = new ArrayList<>();
                strings.add(s);
                return strings;
            });
        }
        return new ArrayList<>(map.values());
    }
}
