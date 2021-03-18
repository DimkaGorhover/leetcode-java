package org.gd.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link MyLoopMeVersionGenerator}.
 */
class MyLoopMeVersionGeneratorTest {

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void generate() {

        assertThat(MyLoopMeVersionGenerator.generate())
                .matches(Pattern.compile("^\\d+\\.\\d{1,4}$"));

        assertThat(MyLoopMeVersionGenerator.generate(0x16C5BEFB86CL))
                .isEqualTo("82.9202");
    }
}