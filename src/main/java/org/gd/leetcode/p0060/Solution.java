package org.gd.leetcode.p0060;

import org.gd.leetcode.common.LeetCode;

/**
 * TODO: https://leetcode.com/problems/permutation-sequence/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-20
 */
@LeetCode(difficulty = LeetCode.Level.MEDIUM)
class Solution {

    private static final int[] F_TABLE = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    int level = 0;

    String perm(String source, String prefix, int search) {
        if (source.length() == 0) {
            return (search == ++level) ? prefix : null;
        }
        String s;
        for (int i = 0; search > level && i < source.length(); i++) {
            if ((s = perm(
                    source.substring(0, i) + source.substring(i + 1),
                    prefix + source.charAt(i),
                    search)) != null) {
                return s;
            }
        }
        return null;
    }

    public String getPermutation(int n, int k) {

        //System.out.println(k / (n - 1));

        return perm(
                //new ArrayList<>(F_TABLE[n]),
                "123456789".substring(0, n),
                "",
                k);
    }
}
