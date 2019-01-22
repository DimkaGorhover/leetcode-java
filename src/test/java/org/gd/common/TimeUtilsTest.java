package org.gd.common;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link TimeUtils};
 *
 * @author Horkhover Dmytro
 * @since 2019-01-15
 */
class TimeUtilsTest {

    @Test
    @DisplayName("ToPrettyDuration")
    void test_ToPrettyDuration() {

        final String s = TimeUtils.toPrettyDuration(Duration.ZERO
                .plusMillis(423)
                .plusSeconds(145)
                .plusMinutes(145)
        );

        assertEquals("27:25:0423", s);
    }
}