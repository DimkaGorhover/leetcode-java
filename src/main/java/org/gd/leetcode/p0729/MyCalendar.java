package org.gd.leetcode.p0729;

import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;

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

    private static final boolean[] ARR = new boolean[10 << 9];

    private final boolean[] calendar = new boolean[ARR.length];

    static {
        Arrays.fill(ARR, true);
    }

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        throw new UnsupportedOperationException(new String(new char[]{ 175, 92, 95, 40, 12_484, 41, 95, 47, 175 }));
    }

}
