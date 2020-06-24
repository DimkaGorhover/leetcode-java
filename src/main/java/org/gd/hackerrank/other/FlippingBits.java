package org.gd.hackerrank.other;

import org.gd.hackerrank.common.HackerRank;

/**
 * https://www.hackerrank.com/challenges/flipping-bits/
 * 
 * @author Horkhover Dmytro
 * @since 2020-06-23
 */
@HackerRank(difficulty = HackerRank.Level.EASY)
class FlippingBits {

    static long flippingBits(long n) {
        long unsignedIntMax = (((long) Integer.MAX_VALUE) << 1) + 1;
        return n ^ unsignedIntMax;
    }
}
