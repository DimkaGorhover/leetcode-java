package org.gd.leetcode.p0729;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/my-calendar-i
 *
 * @author Horkhover Dmytro
 * @since 2020-08-28
 */
@LeetCode(
        name = "My Calendar I",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = LeetCode.Tags.ARRAY
)
class MyCalendar {

    private final ArrayList<Interval> intervals;

    public MyCalendar() {
        intervals = new ArrayList<>();
    }

    private int search(Interval interval) {
        int startIndex = 0;
        int endIndex = intervals.size() - 1;

        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) >>> 1;
            Interval midVal = intervals.get(mid);
            int compare = interval.compareTo(midVal);
            if (compare == 0) {
                return mid;
            }

            if (compare > 0) {
                startIndex = mid + 1;
            } else {
                endIndex = mid - 1;
            }

        }

        return startIndex;
    }

    private void add(Interval interval, int index) {
        while (index >= intervals.size()) {
            intervals.add(null);
        }
        intervals.set(index, interval);
    }

    public boolean book(int start, int end) {

        Interval interval = new Interval(start, end);

        if (intervals.isEmpty()) {
            intervals.add(interval);
            return true;
        }

        int index = search(interval);
        if (index == intervals.size()) {
            intervals.add(interval);
            return true;
        }



        add(interval, index);
        return true;
    }

    @Override
    public String toString() {
        return intervals.toString();
    }
}
