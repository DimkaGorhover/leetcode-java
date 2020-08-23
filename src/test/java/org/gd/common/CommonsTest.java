package org.gd.common;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
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
    @DisplayName("BigInteger Bits")
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
        
        assertEquals(0, Commons.fib(-1));
        assertEquals(0, Commons.fib(0));
        assertEquals(1, Commons.fib(1));
        assertEquals(1, Commons.fib(2));
        assertEquals(2, Commons.fib(3));
        assertEquals(3, Commons.fib(4));
        assertEquals(55, Commons.fib(10));

        assertEquals(0x68A3DD8E61ECCFBDL, Commons.fib(92));
        assertThrows(ArithmeticException.class, () -> Commons.fib(93));
    }

    @Test
    @DisplayName("BigInteger Fib")
    void test_BigFib() {
        assertEquals(new BigInteger("280571172992510140037611932413038677189525", 10), Commons.bigFib(200));
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

        StringBuilder sb = new StringBuilder()
                .append("private static final long[] F = {1L");
        for (int i = 1; i <= 15; i++) {
            sb.append(", ").append(Commons.factorial(i)).append('L');
        }
        System.out.println(sb.append("};"));
    }

    @Test
    @DisplayName("BigInteger Factorial")
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


        StringBuilder sb = new StringBuilder()
                .append("private static final BigInteger[] FACT = {\n")
                .append("    new BigInteger(\"").append(Commons.bigFactorial(0).toString(36)).append("\", 36)");
        for (int i = 1; i < 201; i++) {
            sb.append(",\n    new BigInteger(\"").append(Commons.bigFactorial(i).toString(36)).append("\", 36)");
        }

        System.out.println(sb.append("\n};"));

    }

    private static Stream<Arguments> logArgs() {

        return Stream.of(
            Arguments.of(2d, 256d, /* == */ 8d),
            Arguments.of(2d, 8d, /* == */ 3d),
            Arguments.of(3d, 9d, /* == */ 2d),
            Arguments.of(10d, 1_000d, /* == */ 3d)
        );
    }

    @ParameterizedTest
    @DisplayName("log")
    @MethodSource("logArgs")
    void test_log(double base, double logNumber, double expected) throws Exception {
        
        double actual = Commons.log(base, logNumber);

        assertEquals(expected, actual, 0.000_000_000_001D,
                () -> String.format("log(%1.2f, %1.2f) == %1.2f (expected: %1.2f)%n", base, logNumber, actual, expected));
    }

    private static Stream<Arguments> powArgs() {

        List<Arguments> arguments = new ArrayList<>();
        for (int i = -6; i < 10; i++) {
            arguments.add(Arguments.of(10D, i));
        }
        arguments.add(Arguments.of(8.84372d, -5));
        return arguments.stream();
    }

    @Test
    @DisplayName("Sieve of Eratosthenes")
    void test_sieveOfEratosthenes() {
        long n = 27;
        long[] expected = {2, 3, 5, 7, 11, 13, 17, 19, 23};
        long[] actual = Commons.sieveOfEratosthenes(n);

        assertArrayEquals(expected, actual, () -> 
                String.format("%s%n%s%n",
                        (Arrays.toString(expected) + " <-- expected"),
                        (Arrays.toString(actual) + " <-- actual")));
    }

    @ParameterizedTest
    @MethodSource("powArgs")
    @DisplayName("recursionPow")
    void test_recursionPow(double value, int pow) throws Exception {
        assertEquals(Math.pow(value, pow), Commons.recursionPow(value, pow), 0.000000000000001);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    @DisplayName("gausSum")
    void test_gausSum() {

        assertThrows(ArithmeticException.class, () -> Commons.gausSum0(4_294_967_296L));
        assertThrows(ArithmeticException.class, () -> Commons.linearGausSum0(4_294_967_296L));

        assertEquals(
                BigInteger.valueOf(Commons.linearGausSum0(10)),
                Commons.linearGausSum(BigInteger.valueOf(10)),
                () -> String.format("%d", 10));

        assertEquals(
                Commons.linearGausSum(BigInteger.valueOf(10)),
                Commons.gausSum(BigInteger.valueOf(10)),
                () -> String.format("%d", 10));

        for (int j = 0; j < 100; j++) {
            final int count = ThreadLocalRandom.current().nextInt(1_000_000, 100_000_000);
            assertEquals(
                    Commons.linearGausSum0(count),
                    Commons.gausSum0(count),
                    () -> String.format("%d", count));
            assertEquals(
                    Commons.gausSum0(count),
                    Commons.gausSum(BigInteger.valueOf(count)).longValue(),
                    () -> String.format("%d", count));
        }
    }

    @Test
    @DisplayName("Next Power Of 2")
    void test_nextPowerOf2() {
        long actual = Commons.nextPowerOf2(10);
        assertEquals(16, actual);
        assertTrue(Commons.isPowerOfTwo(actual));
    }

    @Test
    @DisplayName("Prev Power Of 2")
    void test_prevPowerOf2() {
        long actual = Commons.prevPowerOf2(10);
        assertEquals(8, actual);
        assertTrue(Commons.isPowerOfTwo(actual));
    }

    @Test
    @DisplayName("Is Power Of 2")
    void test_isPowerOfTwo() {
        assertFalse(Commons.isPowerOfTwo(-1));
        assertFalse(Commons.isPowerOfTwo(0));
        assertTrue(Commons.isPowerOfTwo(1));
        assertTrue(Commons.isPowerOfTwo(2));
        assertTrue(Commons.isPowerOfTwo(4));
        assertTrue(Commons.isPowerOfTwo(8));
        assertTrue(Commons.isPowerOfTwo(16));
    }

    @Test
    @DisplayName("DigitsCount")
    void test_DigitsCount() {
        for (int i = -9; i < 10; i++) {
            assertEquals(1, Commons.digitsCount(i));
        }

        assertEquals(2, Commons.digitsCount(54));
        assertEquals(4, Commons.digitsCount(9534));
    }

    @Test
    @DisplayName("MaxDigitsCount")
    void test_MaxDigitsCount() {
        assertEquals(3, Commons.maxDigitsCount(
                IntStream.rangeClosed(1, 200).toArray()
        ));
    }
}
