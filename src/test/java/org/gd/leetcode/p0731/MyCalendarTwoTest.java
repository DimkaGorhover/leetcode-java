package org.gd.leetcode.p0731;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link MyCalendarTwo}
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0729.MyCalendarTest
 * @since 2020-10-02
 */
@SuppressWarnings("JavadocReference")
@DisplayName("Test for org.gd.leetcode.p0731.MyCalendarTwo")
class MyCalendarTwoTest {

    @Test
    @DisplayName("Book")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_Book() {

        var calendar = new MyCalendarTwo();

        assertTrue(calendar.book(20, 30));
        assertTrue(calendar.book(0, 10));
        assertTrue(calendar.book(10, 20));

        System.out.println(calendar);

        assertFalse(calendar.book(13, 21));
        assertFalse(calendar.book(13, 17));
        assertFalse(calendar.book(29, 30));
        assertFalse(calendar.book(29, 31));
    }
}
