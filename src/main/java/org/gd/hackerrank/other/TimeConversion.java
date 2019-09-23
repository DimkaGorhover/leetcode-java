package org.gd.hackerrank.other;

import org.gd.hackerrank.common.HackerRank;

/**
 * https://www.hackerrank.com/challenges/time-conversion/problem
 *
 * @since 2019-09-23
 */
@HackerRank(difficulty = HackerRank.Level.EASY)
class TimeConversion {

    private TimeConversion() { throw new UnsupportedOperationException(); }

    static String timeConversion(String s) {

        int hours = ((s.charAt(0) - '0') * 10) + (s.charAt(1) - '0');
        int minutes = ((s.charAt(3) - '0') * 10) + (s.charAt(4) - '0');
        int seconds = ((s.charAt(6) - '0') * 10) + (s.charAt(7) - '0');

        char c = s.charAt(8);
        if (c == 'P' || c == 'p') {
            hours = hours == 12 ? 12 : (hours + 12);
        } else {
            hours = hours == 12 ? 0 : hours;
        }

        char[] chars = new char[8];
        chars[0] = (char) ((hours /10) + '0');
        chars[1] = (char) ((hours % 10) +'0');
        chars[2] = ':';
        chars[3] = (char) ((minutes /10) + '0');
        chars[4] = (char) ((minutes % 10) +'0');
        chars[5] = ':';
        chars[6] = (char) ((seconds /10) + '0');
        chars[7] = (char) ((seconds % 10) +'0');

        return new String(chars);
    }
}
