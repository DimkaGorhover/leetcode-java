package org.gd.common;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.parallel.ExecutionMode.*;

/**
 * Test for {@link Memory}
 *
 * @since 2019-10-10
 */
@Execution(CONCURRENT)
class MemoryTest {

    @Test
    @DisplayName("Plus")
    void test_Plus() throws Exception {
        assertEquals(
                Memory.ofGbs(4),
                Memory.ofGbs(1)
                        .plus(Memory.ofMbs(1 << 10))
                        .plus(Memory.ofKbs(1 << 20))
                        .plus(Memory.ofBytes(1 << 30)));
    }

    @Test
    @DisplayName("Minus")
    void test_Minus() throws Exception {
        assertEquals(
                Memory.ofGbs(8_589_934_500L),
                Memory.ofBytes(Long.MAX_VALUE)
                        .minus(Memory.ofGbs(91))
                        .minus(Memory.ofBytes(1073741823L)));
    }
}