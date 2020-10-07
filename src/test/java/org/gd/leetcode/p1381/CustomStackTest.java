package org.gd.leetcode.p1381;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @see CustomStack
 */
@DisplayName("LeetCode #1381: Design a Stack With Increment Operation")
class CustomStackTest {

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test() {

        CustomStack customStack = new CustomStack(3);
        assertEquals(-1, customStack.pop());
        assertEquals(-1, customStack.pop());
        assertEquals(List.of().toString(), customStack.toString());

        customStack.push(1);
        assertEquals(List.of(1).toString(), customStack.toString());

        customStack.push(2);
        assertEquals(List.of(1, 2).toString(), customStack.toString());

        assertEquals(2, customStack.pop());
        assertEquals(List.of(1).toString(), customStack.toString());

        customStack.push(2);
        assertEquals(List.of(1, 2).toString(), customStack.toString());

        customStack.push(3);
        assertEquals(List.of(1, 2, 3).toString(), customStack.toString());

        customStack.push(4);
        assertEquals(List.of(1, 2, 3).toString(), customStack.toString());

        customStack.increment(5, 100);

        customStack.increment(2, 100);

        assertEquals(103, customStack.pop());
        assertEquals(202, customStack.pop());
        assertEquals(201, customStack.pop());
        assertEquals(-1, customStack.pop());
        assertEquals(-1, customStack.pop());
    }
}