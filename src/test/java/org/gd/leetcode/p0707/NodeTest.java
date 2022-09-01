package org.gd.leetcode.p0707;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NodeTest {

    @Test
    void testHashCode() {
        int val = ThreadLocalRandom.current().nextInt(0, 1 << 10);
        assertEquals(val, new Node(val).hashCode());
    }

    @Test
    void testToString() {
        int val = ThreadLocalRandom.current().nextInt(0, 1 << 10);
        assertEquals("" + val, new Node(val).toString());
    }
}