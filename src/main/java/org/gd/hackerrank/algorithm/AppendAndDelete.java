package org.gd.hackerrank.algorithm;

import org.gd.hackerrank.common.HackerRank;

/**
 * https://www.hackerrank.com/challenges/append-and-delete/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-17
 */
@HackerRank(difficulty = HackerRank.Level.EASY)
class AppendAndDelete {

    private AppendAndDelete() { throw new UnsupportedOperationException(); }

    private static int length(String str) {
        return str == null ? 0 : str.length();
    }

    static String appendAndDelete(String shortString, String longString, int k) {

        final int shortStringLength = length(shortString);
        final int longStringLength = length(longString);

        if (shortStringLength + longStringLength <= k)
            return "Yes";

        if (shortStringLength > longStringLength)
            return appendAndDelete(longString, shortString, k);

        int i = 0;
        while (i < shortStringLength) {

            if (shortString.charAt(i) != longString.charAt(i))
                break;

            i++;
        }

        k -= shortStringLength - i;
        k -= longStringLength - i;

        return k >= 0 && k % 2 == 0 ? "Yes" : "No";
    }
}
