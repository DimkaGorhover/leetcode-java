package org.gd.leetcode.p0895;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link FreqStack}
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0146.LRUCacheTest
 * @see org.gd.leetcode.p0460.LFUCacheTest
 * @since 2020-09-22
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #895: Maximum Frequency Stack")
class FreqStackTest {

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Push & Pop")
    void pop() {
        var stack = new FreqStack();

        java.util.Arrays.asList(5, 7, 5, 7, 4, 5).forEach(stack::push);

        assertEquals(5, stack.pop());
        assertEquals(7, stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(7, stack.pop());
        assertEquals(5, stack.pop());
    }
}