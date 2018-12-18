package org.gd.common;

import org.junit.jupiter.api.*;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Commons};
 *
 * @author Horkhover Dmytro
 * @since 2018-12-18
 */
class CommonsTest {

    @Test
    @DisplayName("Fib")
    void test_Fib() {
        assertEquals(0x68A3DD8E61ECCFBDL, Commons.fib(92));
        assertThrows(ArithmeticException.class, () -> Commons.fib(93));
    }

    @Test
    @DisplayName("BigFib")
    void test_BigFib() {
        assertEquals(new BigInteger("280571172992510140037611932413038677189525"), Commons.bigFib(200));
        assertEquals(BigInteger.valueOf(0x68A3DD8E61ECCFBDL), Commons.bigFib(92));
        assertSame(Commons.bigFib(92), Commons.bigFib(92));
        assertSame(Commons.bigFib(91), Commons.bigFib(91));
        assertNotSame(Commons.bigFib(90), Commons.bigFib(90));
    }
}