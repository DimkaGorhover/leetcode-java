package org.gd.leetcode.p0873;

import org.gd.common.Commons;

/**
 * TODO: https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 *
 * @author Gorkhover D.
 * @since 2018-11-04
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(
                Commons.bigFib(100)
        );
    }

    public int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        throw new UnsupportedOperationException();
    }
}
