package org.gd.leetcode.p0389;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-31
 */
class BitManipulationSolution implements Solution {

    @Override
    public char findTheDifference(String s, String t) {

        final int sLen = s.length();
        final int tLen = t.length();

        int sum = 0;

        for (int i = 0; i < sLen; ++i)
            sum ^= (t.charAt(i) ^ s.charAt(i));

        return (char) (sum ^ t.charAt(tLen - 1));
    }
}
