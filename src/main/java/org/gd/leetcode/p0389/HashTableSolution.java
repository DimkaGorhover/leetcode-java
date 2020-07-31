package org.gd.leetcode.p0389;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-31
 */
class HashTableSolution implements Solution {

    @Override
    public char findTheDifference(String s, String t) {
        int[] set = new int['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++)
            set[s.charAt(i) - 'a']++;

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int quota = --set[c - 'a'];
            if (quota < 0)
                return c;
        }

        return 0;
    }
}
