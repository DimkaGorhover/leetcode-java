package org.gd.leetcode.p0729;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

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
    //@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_Book() {

        var cal = new MyCalendar();

        cal.book(0, 10);
        cal.book(10, 20);
        cal.book(20, 30);

        assertFalse(cal.book(13, 17));
    }
}
