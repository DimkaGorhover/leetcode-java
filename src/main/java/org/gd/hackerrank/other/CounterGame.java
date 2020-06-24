package org.gd.hackerrank.other;

import org.gd.hackerrank.common.HackerRank;

/**
 * TODO: https://www.hackerrank.com/challenges/counter-game/
 */
@HackerRank(difficulty = HackerRank.Level.MEDIUM)
class CounterGame {

    public static void main(String[] args) {
        System.out.println(
            counterGame(10)
        );
    }

    static String counterGame(long n) {
        long v = n;
        v--;
        v |= v >> 1;
        v |= v >> 2;
        v |= v >> 4;
        v |= v >> 8;
        v |= v >> 16;
        v++;
        return "" + v;
    }
}
