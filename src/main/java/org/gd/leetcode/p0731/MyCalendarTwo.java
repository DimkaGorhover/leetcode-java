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
        state = LeetCode.State.TODO,
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

        int index = search(start, end);
        switch (index) {
            case -2:
                return true;
            case -1:
                return false;
            default:
                insert(index, new int[]{start, end, 0});
                return true;
        }
    }

    private void splitInsert() {

    }

    private int search(int start, int end) {

        int startIndex = 0, endIndex = size - 1;

        while (startIndex <= endIndex) {

            int midIndex = (startIndex + endIndex) >>> 1;
            int[] midVal = intervals[midIndex];

            int compare = Integer.compare(start, midVal[0]);
            if (compare == 0) {
                return -1;
            }

            if (compare < 0) {
                // [ interval ] | [ midVal ]
                if (end > midVal[0]) {
                    // intervals intersect each other

                    if (midVal[2] == 1) {
                        return -1;
                    }

                    return -2;
                }
                endIndex = midIndex - 1;
                continue;
            }


            // [ midVal ] | [ interval ]
            if (midVal[1] > start) {
                // intervals intersect each other

                if (midVal[2] == 1) {
                    return -1;
                }

                return -2;
            }
            startIndex = midIndex + 1;
        }

        return startIndex;
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

    @Override
    public String toString() {
        if (size == 0)
            return "[]";

        StringBuilder sb = new StringBuilder().append("[");

        java.util.function.Consumer<int[]> consumer = interval -> {
            int count = interval[2];
            for (int i = 0; i <= count; i++) {
                sb.append('[');
            }
            sb.append(count).append(',').append(interval[1]);
            for (int i = 0; i <= count; i++) {
                sb.append(')');
            }
        };

        consumer.accept(intervals[0]);

        for (int i = 1; i < size; i++) {

            if (intervals[i] == null)
                continue;

            sb.append(',').append(' ');
            consumer.accept(intervals[i]);
        }

        return sb.append("]").toString();
    }
}
