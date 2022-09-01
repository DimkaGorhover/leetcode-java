package org.gd.leetcode.p0641;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("LeetCode #641: Design Circular Deque")
class MyCircularDequeTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new LinkedListQFactory()),
                Arguments.of(new ArrayQFactory())
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void test_001(QFactory qf) {

        var q = qf.apply(3);

        assertTrue(q.insertLast(1));
        assertTrue(q.insertLast(2));
        assertTrue(q.insertFront(3));

        assertFalse(q.insertFront(4));

        assertEquals(2, q.getRear());

        assertEquals(3, q.getFront());

        assertTrue(q.deleteFront());
        assertEquals(1, q.getFront());

        assertTrue(q.deleteFront());
        assertEquals(2, q.getFront());

        assertTrue(q.deleteFront());
        assertEquals(-1, q.getFront());

        assertFalse(q.deleteFront());
    }

}