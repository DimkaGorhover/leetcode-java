package org.gd.leetcode.p1185;

import org.gd.leetcode.common.LeetCode;

import java.time.LocalDate;

/**
 * https://leetcode.com/problems/day-of-the-week/
 *
 * @since 2019-10-02
 */
@LeetCode(difficulty = LeetCode.Level.EASY, tags = LeetCode.Tags.ARRAY)
class Solution {

    //@formatter:off
    public String dayOfTheWeek(int day, int month, int year) {
        switch (LocalDate.of(year, month, day).getDayOfWeek()) {
            case MONDAY:    return "Monday";
            case TUESDAY:   return "Tuesday";
            case WEDNESDAY: return "Wednesday";
            case THURSDAY:  return "Thursday";
            case FRIDAY:    return "Friday";
            case SATURDAY:  return "Saturday";
            case SUNDAY:    return "Sunday";
        }
        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }
    //@formatter:on
}
