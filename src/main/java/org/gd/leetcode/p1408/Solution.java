package org.gd.leetcode.p1408;

import java.util.*;

/**
 * https://leetcode.com/problems/string-matching-in-an-array/
 *
 * @author Horkhover Dmytro
 * @since 2020-09-27
 */
class Solution {

    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        LinkedList<String> set = new LinkedList<>();
        Collections.addAll(set, words);





        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }
}
