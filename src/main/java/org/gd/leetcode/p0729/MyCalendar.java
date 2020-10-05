package org.gd.leetcode.p0729;

import org.gd.leetcode.common.LeetCode;

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

    private int[][] intervals = new int[10][];
    private int size = 0;

    public MyCalendar() {}

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

    private void growIfNeed() {
        if (size + 1 < intervals.length)
            return;

        final long newCapacity = size + 16;
        if (newCapacity > Integer.MAX_VALUE - 8)
            throw new OutOfMemoryError();

        int[][] arr = new int[(int) newCapacity][];
        System.arraycopy(intervals, 0, arr, 0, intervals.length);
        intervals = arr;
    }

    public boolean book(int start, int end) {

        if (size == 0) {
            intervals[size++] = new int[]{start, end};
            return true;
        }

        int index = search(start, end);
        if (index < 0) {
            return false;
        }

        insert(index, new int[]{start, end});
        return true;
    }

    @SuppressWarnings("DuplicatedCode")
    private void insert(int index, int[] interval) {

        growIfNeed();

        if (index == size) {
            intervals[size++] = interval;
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
            sb.append('[');
            if (interval != null) {
                sb.append(interval[0]).append(',').append(interval[1]);
            }
            sb.append(')');
        };

        consumer.accept(intervals[0]);

        for (int i = 1; i < size; i++) {
            sb.append(',').append(' ');
            consumer.accept(intervals[i]);
        }

        return sb.append("]").toString();
    }
}
