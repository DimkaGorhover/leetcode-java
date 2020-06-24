package org.gd.hackerrank.other;

import java.util.Arrays;

import org.gd.hackerrank.common.HackerRank;

/**
 * https://www.hackerrank.com/challenges/staircase
 *
 * @author Horkhover Dmytro
 * @since 2018-11-18
 */
@HackerRank(difficulty = HackerRank.Level.EASY)
class Staircase {

    private Staircase() { throw new UnsupportedOperationException(); }

    static void staircase(int n) {
        char[] chars = new char[n + 1];
        Arrays.fill(chars, 0, n, ' ');
        chars[n] = '\n';
        StringBuilder sb = new StringBuilder(chars.length * n);
        for (int i = 1; i <= n; i++) {
            chars[n - i] = '#';
            sb.append(chars, 0, chars.length);
        }
        System.out.print(sb.toString());
    }
}
