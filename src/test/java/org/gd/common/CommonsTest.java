package org.gd.common;

import org.junit.jupiter.api.*;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Commons};
 *
 * @author Horkhover Dmytro
 * @since 2018-12-18
 */
class CommonsTest {

    @Test
    @DisplayName("BigIntegerBits")
    void test_BigIntegerBits() {
        final BigInteger two = BigInteger.valueOf(2);
        for (int i = 0; i < 100; i++) {
            int bits = ThreadLocalRandom.current().nextInt(4, 23);
            assertEquals(two.pow(bits), Commons.bigIntegerBits(bits));
            bits = ThreadLocalRandom.current().nextInt(100, 200);
            assertEquals(two.pow(bits), Commons.bigIntegerBits(bits));
        }
    }

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

    @Test
    @DisplayName("factorial")
    void test_factorial() {
        assertEquals(6, Commons.factorial(3));
        assertEquals(24, Commons.factorial(4));
        assertThrows(ArithmeticException.class, () -> Commons.factorial(21));
    }

    @Test
    @DisplayName("test_bigFactorial")
    void test_bigFactorial() {
        assertEquals(
                BigInteger.valueOf(6),
                Commons.bigFactorial(3));
        assertEquals(
                BigInteger.valueOf(24),
                Commons.bigFactorial(4));
        assertEquals(
                new BigInteger("2H810LN1DXTFEZNBWZFUI7HGPY6ZJCYT6S3D2B2IPKW000000000000000", 36),
                Commons.bigFactorial(64));
    }
}