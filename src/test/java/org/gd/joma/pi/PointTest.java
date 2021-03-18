package org.gd.joma.pi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link Point}.
 */
class PointTest {

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void testPoint() {
        assertThat(new Point(1, 1))
                .isEqualTo(new Point(1, 1))
                .hasSameHashCodeAs(new Point(1, 1))
                .hasToString(new Point(1, 1).toString());
    }
}
