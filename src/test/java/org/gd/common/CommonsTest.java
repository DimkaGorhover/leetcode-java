package org.gd.common;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    @Test
    @DisplayName("log")
    void test_log() throws Exception {
        assertEquals(8, Commons.log(2, 256));
        assertEquals(2, Commons.log(3, 9));
        assertEquals(3, Commons.log(10, 1000));
    }

    private static Stream<Arguments> powArgs() {

        List<Arguments> arguments = new ArrayList<>();
        for (int i = -6; i < 10; i++) {
            arguments.add(Arguments.of(10D, i));
        }
        arguments.add(Arguments.of(8.84372d, -5));
        return arguments.stream();
    }

    @ParameterizedTest
    @MethodSource("powArgs")
    //@DisplayName("recursionPow")
    void test_recursionPow(double value, int pow) throws Exception {
        assertEquals(Math.pow(value, pow), Commons.recursionPow(value, pow), 0.000000000000001);
    }
}