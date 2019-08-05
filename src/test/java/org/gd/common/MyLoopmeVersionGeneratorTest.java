package org.gd.common;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MyLoopmeVersionGeneratorTest {

    @Test
    void generate() {
        assertEquals(
                "82.9202",
                MyLoopmeVersionGenerator.generate(0x16C5BEFB86CL)
        );
    }
}