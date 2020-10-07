package org.gd.leetcode.p0731;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.function.Executable;

import lombok.NonNull;

class MyCalendarExecutableFactory {

    private final MyCalendarTwo calendar;

    MyCalendarExecutableFactory() {
        this(new MyCalendarTwo());
    }

    MyCalendarExecutableFactory(MyCalendarTwo calendar) {
        requireNonNull(calendar, "\"calendar\" cannot be null");
        this.calendar = calendar;
    }

    Executable create(int start, int end, boolean expected) {
        return new MyCalendarExecutable(start, end, expected);
    }

    class MyCalendarExecutable implements Executable {

        private final int start, end;
        private final boolean expected;

        MyCalendarExecutable(int start, int end, boolean expected) {
            this.start = start;
            this.end = end;
            this.expected = expected;
        }

        @Override
        public void execute() throws Throwable {

            String before = calendar.toString();

            boolean actual = calendar.book(start, end);

            String after = calendar.toString();

            assertEquals(expected, actual, () -> {

                return String.format("%n interval = [%2d,%2d);%n before = %s;%n  after = %s%n", start, end, before, after);
            });
        }

        @Override
        public String toString() {
            return String.format("[%d,%d) expected: %b", start, end, expected);
        }
    }
}
