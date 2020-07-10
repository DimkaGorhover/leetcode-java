package org.gd.leetcode.p0622;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.IntFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyCircularQueueTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of((IntFunction<MyCircularQueue>) ArrayMyCircularQueue::new),
                Arguments.of((IntFunction<MyCircularQueue>) LinkedListMyCircularQueue::new)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void test_001(IntFunction<MyCircularQueue> qf) {
        var q = qf.apply(3);

        assertTrue(q.enQueue(1));
        assertTrue(q.enQueue(2));
        assertTrue(q.enQueue(3));
        assertFalse(q.enQueue(4));

        assertEquals(3, q.Rear());

        assertTrue(q.isFull());
        assertTrue(q.deQueue());

        assertTrue(q.enQueue(4));

        assertEquals(4, q.Rear());


        assertTrue(q.deQueue());
        assertTrue(q.deQueue());
        assertTrue(q.deQueue());
        assertFalse(q.deQueue());
    }

    @ParameterizedTest
    @MethodSource("args")
    void test_002(IntFunction<MyCircularQueue> qf) {

//"Front","deQueue","deQueue","deQueue"]
//[],[],[],[]]

        var q = qf.apply(6);
        assertTrue(q.enQueue(6));
        assertEquals(6, q.Rear());
        assertEquals(6, q.Rear());
        assertTrue(q.deQueue());
        assertTrue(q.enQueue(5));
        assertEquals(5, q.Rear());
        assertTrue(q.deQueue());
        assertEquals(-1, q.Front());
        assertFalse(q.deQueue());
        assertFalse(q.deQueue());
        assertFalse(q.deQueue());
    }
}