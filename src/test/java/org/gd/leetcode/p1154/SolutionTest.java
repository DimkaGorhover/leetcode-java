package org.gd.leetcode.p1154;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @since 2019-09-14
 */
@DisplayName("LeetCode #1154: Day of the Year")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static Stream<Arguments> args() {
        return Stream.concat(
                IntStream.rangeClosed(1, 365).mapToObj(dayOfYear -> Arguments.of(2019, dayOfYear)),
                IntStream.rangeClosed(1, 366).mapToObj(dayOfYear -> Arguments.of(2020, dayOfYear))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("DayOfYear")
    void test_DayOfYear(final int year, final int dayOfYear) throws Exception {

        LocalDate localDate = LocalDate.of(year, 1, 1).withDayOfYear(dayOfYear);
        String format = DTF.format(localDate);

        assertEquals(
                localDate.getDayOfYear(),
                new Solution().dayOfYear(format),
                () -> '\n'
                        + "localDate: " + localDate + '\n'
                        + "format: " + format + '\n'
                        + "year: " + year + '\n'
                        + "dayOfYear: " + dayOfYear + '\n'
                        + '\n'
        );
    }

    @Test
    @DisplayName("DayOfYear Validation")
    void test_DayOfYear_throws() throws Exception {
        Solution solution = new Solution();
        assertThrows(IllegalArgumentException.class, () -> solution.dayOfYear("2019-13-01"));
        assertThrows(IllegalArgumentException.class, () -> solution.dayOfYear("2019-00-01"));
        assertDoesNotThrow(() -> solution.dayOfYear("2020-02-29"));
    }
}