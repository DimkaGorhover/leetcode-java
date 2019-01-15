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

        final String s = TimeUtils.toPrettyDuration(Duration.ofMillis(423)
                .plus(Duration.ofSeconds(145))
                .plus(Duration.ofMinutes(145))
        );

        assertEquals("27:25:0423", s);
    }
}