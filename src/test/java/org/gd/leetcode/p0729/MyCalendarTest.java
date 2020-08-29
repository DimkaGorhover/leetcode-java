package org.gd.leetcode.p0729;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

/**
 * Test for {@link MyCalendar}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-28
 */
@DisplayName("Test for org.gd.leetcode.p0729.MyCalendar")
class MyCalendarTest {

    @Test
    @DisplayName("Book")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_Book() {

        var i1 = new Interval(17, 18);
        var i2 = new Interval(10, 20);

        System.out.println(i1.compareTo(i2));
        System.out.println(i2.compareTo(i1));
    }
}
