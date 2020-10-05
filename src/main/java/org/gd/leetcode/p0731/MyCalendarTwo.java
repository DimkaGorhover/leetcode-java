package org.gd.leetcode.p0731;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/my-calendar-ii/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0729.MyCalendar
 * @see org.gd.leetcode.p0732.MyCalendarThree
 * @since 2020-10-02
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "My Calendar II",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.FIXME,
        tags = {
                LeetCode.Tags.ORDERED_MAP
        }
)
class MyCalendarTwo {

    private int[][] intervals;
    private int size;

    public MyCalendarTwo() {
        intervals = new int[10][];
        size = 0;
    }

    public boolean book(int start, int end) {

        if (size == 0) {
            intervals[0] = new int[]{start, end, 0};
            size++;
            return true;
        }

        int startIndex = 0, endIndex = size - 1;

        while (startIndex <= endIndex) {

            int midIndex = (startIndex + endIndex) >>> 1;
            int[] midVal = intervals[midIndex];

            int compare = Integer.compare(start, midVal[0]);

            // intervals have the same start point
            if (compare == 0) {

                if (midVal[2] > 0) {
                    return false;
                }

                if (midVal[1] == end) {
                    midVal[2]++;
                    return true;
                }

                int prevEnd = midVal[1];
                midVal[1] = Math.min(prevEnd, end);
                midVal[2]++;
                insert(midIndex + 1, new int[]{midVal[1], Math.max(prevEnd, end), 0});

                return true;
            }

            // [ interval ] | [ midVal ]
            if (compare < 0) {

                // ----------------------------------------------------------------
                // intervals intersect each other
                //
                // [ interval --- ]
                //       [ midVal ----- ]
                //
                // [ interval --------- ]
                //       [ midVal ]
                // ----------------------------------------------------------------
                if (end > midVal[0]) {

                    if (midVal[2] > 0) {
                        return false;
                    }

                    int prevStart = midVal[0];
                    int prevEnd = midVal[1];

                    midVal[0] = start;
                    midVal[1] = prevStart;

                    int[] interval0 = {prevStart, Math.min(end, prevEnd), 1};
                    int[] interval1 = {interval0[1], Math.max(end, prevEnd), 0};

                    insert(midIndex + 1, interval0, interval1);

                    return true;
                }

                endIndex = midIndex - 1;
                continue;
            }

            // ----------------------------------------------------------------
            // intervals intersect each other
            //
            // [ midVal --- ]
            //      [ interval --- ]
            //
            // [ midVal ------------- ]
            //      [ interval ]
            // ----------------------------------------------------------------
            if (midVal[1] > start) {

                if (midVal[2] > 0) {
                    return false;
                }

                int prevEnd = midVal[1];
                midVal[1] = start;

                int[] interval0 = {midVal[1], Math.min(end, prevEnd), 1};
                int[] interval1 = {interval0[1], Math.max(end, prevEnd), 0};

                insert(midIndex + 1, interval0, interval1);

                return true;
            }

            startIndex = midIndex + 1;
        }

        //return startIndex;

        insert(startIndex, new int[]{start, end, 0});
        return true;
    }

    private void growIfNeed() {
        if (size + 3 < intervals.length)
            return;

        final long newCapacity = size + 13;
        if (newCapacity > Integer.MAX_VALUE - 8)
            throw new OutOfMemoryError();

        int[][] arr = new int[(int) newCapacity][];
        System.arraycopy(intervals, 0, arr, 0, intervals.length);
        intervals = arr;
    }

    private void insert(int index, int[] interval) {
        growIfNeed();

        if (index == size) {
            intervals[index] = interval;
            size++;
            return;
        }

        System.arraycopy(intervals, index, intervals, index + 1, size - index);
        size++;
        intervals[index] = interval;
    }

    private void insert(int index, int[] interval0, int[] interval1) {
        growIfNeed();

        if (index == size) {
            intervals[index] = interval0;
            intervals[index + 1] = interval1;
            size += 2;
            return;
        }

        System.arraycopy(intervals, index, intervals, index + 2, size - index);
        size += 2;
        intervals[index] = interval0;
        intervals[index + 1] = interval1;
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";

        StringBuilder sb = new StringBuilder().append("[ ");

        java.util.function.Consumer<int[]> consumer = interval -> {

            if (interval == null) {
                sb.append("[]");
                return;
            }

            int count = interval[2];
            //noinspection StringRepeatCanBeUsed
            for (int i = 0; i <= count; i++) {
                sb.append('[');
            }
            sb.append(interval[0]).append(',').append(interval[1]);
            //noinspection StringRepeatCanBeUsed
            for (int i = 0; i <= count; i++) {
                sb.append(')');
            }
        };

        consumer.accept(intervals[0]);

        for (int i = 1; i < size; i++) {
            sb.append(',').append(' ');
            consumer.accept(intervals[i]);
        }

        return sb.append(" ]").toString();
    }
}
