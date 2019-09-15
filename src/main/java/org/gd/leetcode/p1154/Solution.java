package org.gd.leetcode.p1154;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/day-of-the-year/
 *
 * @since 2019-09-14
 */
@LeetCode(difficulty = LeetCode.Level.EASY, tags = LeetCode.Tags.MATH)
class Solution {

    private static final int[][] NORM_YEAR_DAYS = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334}
    };

    private static final int[][] LEAP_YEAR_DAYS = {
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335}
    };

    private static int[][] days(int year) {
        switch (year) {
            case 1900:
            case 2100:
            case 2200:
            case 2300:
                return NORM_YEAR_DAYS;
        }
        return year % 4 == 0 ? LEAP_YEAR_DAYS : NORM_YEAR_DAYS;
    }

    public int dayOfYear(String date) {

        int year = 0;
        for (int i = 0; i < 4; i++)
            year = year * 10 + date.charAt(i) - '0';

        int month = 0;
        for (int i = 5; i < 7; i++)
            month = month * 10 + date.charAt(i) - '0';
        if (month < 1 || 12 < month)
            throw new IllegalArgumentException("month");

        int day = 0;
        for (int i = 8; i < 10; i++)
            day = day * 10 + date.charAt(i) - '0';
        if (day < 1 || days(year)[0][month - 1] < day)
            throw new IllegalArgumentException("day");

        return days(year)[1][month - 1] + day;
    }
}
