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
@DisplayName("LeetCode #729: My Calendar I")
class MyCalendarTest {

    @Test
    @DisplayName("Book")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_Book() {

        var calendar = new MyCalendar();

        assertTrue(calendar.book(20, 30));
        assertTrue(calendar.book(0, 10));
        assertTrue(calendar.book(10, 20));

        System.out.println(calendar);

        assertFalse(calendar.book(13, 17));
        assertFalse(calendar.book(29, 30));
        assertFalse(calendar.book(29, 31));
    }
}
