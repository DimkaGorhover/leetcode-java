package org.gd.hackerrank.other;

import org.gd.hackerrank.common.HackerRank;

/**
 * TODO: https://www.hackerrank.com/challenges/counter-game/
 */
@HackerRank(difficulty = HackerRank.Level.MEDIUM)
class CounterGame {

    static String counterGame(long n) {
        boolean luise = false;
        while (n > 1) {
            luise = !luise;
            long p2 = prevPow2(n);
            n = (n == p2) ? (n / 2) : (n - p2);
        }
        return luise ? "Louise" : "Richard";
    }

    private static long prevPow2(long n) {
        n--;
        for (int i = 0; i < 6; i++)
            n |= n >> (1 << i);
        return n - (n >> 1);
    }
}
