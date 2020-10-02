package org.gd.leetcode.p0729;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/my-calendar-i
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0731.MyCalendarTwo
 * @see org.gd.leetcode.p0732.MyCalendarThree
 * @since 2020-08-28
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "My Calendar I",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.BINARY_SEARCH
        }
)
class MyCalendar {

    private final ArrayList<int[]> intervals;

    public MyCalendar() {
        intervals = new ArrayList<>();
    }

    private int search(int start, int end) {

        int startIndex = 0, endIndex = intervals.size() - 1;

        int[] midVal;
        int midIndex = 0;

        while (startIndex <= endIndex) {
            midIndex = (startIndex + endIndex) >>> 1;
            midVal = intervals.get(midIndex);

            int compare = Integer.compare(start, midVal[0]);
            if (compare == 0) {
                return -1;
            }

            if (compare < 0) {
                // [ interval ] | [ midVal ]
                if (end > midVal[0]) {
                    // intervals intersect each other
                    return -1;
                }
                endIndex = midIndex - 1;
                continue;
            }


            // [ midVal ] | [ interval ]
            if (midVal[1] > start) {
                // intervals intersect each other
                return -1;
            }
            startIndex = midIndex + 1;
        }

        return startIndex;
    }

    public boolean book(int start, int end) {

        if (intervals.isEmpty()) {
            intervals.add(new int[]{start, end});
            return true;
        }

        int index = search(start, end);
        if (index < 0) {
            return false;
        }

        intervals.add(index, new int[]{start, end});
        return true;
    }

    @Override
    public String toString() {
        if (intervals.isEmpty())
            return "[]";

        StringBuilder sb = new StringBuilder().append("[");
        java.util.function.Consumer<int[]> consumer = interval ->
                sb.append('[').append(interval[0]).append(',').append(interval[1]).append(')');

        java.util.Iterator<int[]> iterator = intervals.iterator();
        if (iterator.hasNext()) {
            consumer.accept(iterator.next());
            while (iterator.hasNext()) {
                sb.append(',').append(' ');
                consumer.accept(iterator.next());
            }
        }

        return sb.append("]").toString();
    }
}
