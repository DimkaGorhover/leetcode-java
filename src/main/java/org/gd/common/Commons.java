package org.gd.common;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Horkhover Dmytro
 * @since 2018-12-18
 */
public final class Commons {

    private static final long[] FACTORIALS = new long[21];

    private static final long GAUS_MAX_VAL = 4_294_967_295L;
    private static final BigInteger GAUS_MAX_VAL_BI = BigInteger.valueOf(GAUS_MAX_VAL);

    private static final BigInteger[] BIG_INTEGERS_BITS = new BigInteger[32];

    private static final BigInteger
            BIG_92 = BigInteger.valueOf(92),
            BIG_FIB_91 = BigInteger.valueOf(fib(91)),
            BIG_FIB_92 = BigInteger.valueOf(fib(92)),
            BIG_FACT_20 = BigInteger.valueOf(factorial(20));

    static {
        BIG_INTEGERS_BITS[0] = BigInteger.ONE;
        BIG_INTEGERS_BITS[1] = BigInteger.TWO;
        for (int i = 2; i < BIG_INTEGERS_BITS.length; i++)
            BIG_INTEGERS_BITS[i] = bigIntegerBits0(i);
    }

    private Commons() { throw new UnsupportedOperationException(); }

    private static BigInteger bigIntegerBits0(int bits) {
        return bits < 63
                ? BigInteger.valueOf(1L << bits)
                : BigInteger.ONE.shiftLeft(bits);
    }

    public static int max(int v0, int v1) {
        return Math.max(v0, v1);
    }

    public static int max(int v0, int v1, int v2) {
        return max(max(v0, v1), v2);
    }

    public static int max(int v0, int v1, int v2, int v3) {
        return max(max(v0, v1), max(v2, v3));
    }

    public static int max(int v0, int v1, int v2, int v3, int v4) {
        return max(max(v0, v1), max(v2, v3), v4);
    }

    public static int max(int v0, int v1, int v2, int v3, int v4, int v5) {
        return max(max(v0, v1), max(v2, v3), max(v4, v5));
    }

    /**
     * @param bits power of two
     *
     * @return {@link BigInteger}
     */
    public static BigInteger bigIntegerBits(int bits) {
        if (bits < 0) return BigInteger.ZERO;
        if (bits < BIG_INTEGERS_BITS.length) return BIG_INTEGERS_BITS[bits];
        return bigIntegerBits0(bits);
    }

    /**
     * @throws ArithmeticException if {@code n > 92}
     */
    public static long fib(int n) throws ArithmeticException {
        if (n < 2) return 1;
        if (n > 92) throw new ArithmeticException("long overflow");
        long a1 = 0, a2 = 1, f = a2;
        for (int i = 2; i <= n; i++) {
            f = Math.addExact(a1, a2);
            a1 = a2;
            a2 = f;
        }
        return f;
    }

    /**
     * https://habr.com/ru/post/261159/
     *
     * @param n
     *
     * @return instance of {@link BigInteger}
     */
    public static BigInteger bigFib(int n) {
        if (n < 2) return BigInteger.ONE;
        if (n < 91) return BigInteger.valueOf(fib(n));
        switch (n) {
            case 91: return BIG_FIB_91;
            case 92: return BIG_FIB_92;
        }
        BigInteger a1 = BIG_FIB_91, a2 = BIG_FIB_92, f = a2;
        for (int i = 93; i <= n; i++) {
            f = a1.add(a2);
            a1 = a2;
            a2 = f;
        }
        return f;
    }

    public static BigInteger fib(BigInteger n) {
        if (n.compareTo(BigInteger.TWO) < 0)
            return BigInteger.ONE;

        if (n.compareTo(BIG_92) <= 0)
            return BigInteger.valueOf(fib(n.intValue()));

        // TODO: implement it
        throw new UnsupportedOperationException();

        // BigInteger a1 = BIG_FIB_91, a2 = BIG_FIB_92, f = a2;
        // for (int i = 91; i <= n; i++) {
        //     f = a1.add(a2);
        //     a1 = a2;
        //     a2 = f;
        // }
        // return f;
    }

    /**
     * http://mathematichka.ru/school/combinatorics/combination.html
     */
    public static long factorial(int n) {
        if (n < 0)
            return 1;

        if (n > 20)
            throw new ArithmeticException("long overflow");

        if (FACTORIALS[n] > 0)
            return FACTORIALS[n];

        long s = 1;
        for (int i = 2; i <= n; i++)
            FACTORIALS[i] = s = s * i;

        return FACTORIALS[n];
    }

    public static long combinations(int n, int m) {

        if (n > 20) {

            BigInteger v1 = bigFactorial(n);
            BigInteger v2 = bigFactorial(n - m);
            BigInteger v3 = bigFactorial(m);

            return v1.divide(v2.multiply(v3)).longValueExact();
        }

        return factorial(n) / (factorial(n - m) * factorial(m));
    }

    public static BigInteger bigFactorial(int n) {

        if (n < 20)
            return BigInteger.valueOf(factorial(n));

        if (n == 20)
            return BIG_FACT_20;

        BigInteger s = BIG_FACT_20;
        for (int i = 21; i <= n; i++)
            s = s.multiply(BigInteger.valueOf(i));

        return s;
    }

    public static double sigmoid(double x) {
        return 1. / (1. + Math.exp(-x));
    }

    /**
     * <a hrep="https://www.baeldung.com/java-logarithms">Calculating Logarithms in Java</a>
     */
    public static double log(double base, double logNumber) {
        return Math.log(logNumber) / Math.log(base);
    }

    public static double log2(double value) {
        return log(2, value);
    }

    @SuppressWarnings("DuplicatedCode")
    public static double recursionPow(double v, int pow) { // TODO: implement this method without recursion
        switch (pow) {
            case -4: return v / v / v / v / v / v;
            case -3: return v / v / v / v / v;
            case -2: return v / v / v / v;
            case -1: return v / v / v;
            case 0: return 1;
            case 1: return v;
            case 2: return v * v;
            case 3: return v * v * v;
            case 4: return v * v * v * v;
        }
        double half = recursionPow(v, pow >> 1);
        return half * half * recursionPow(v, pow % 2);
    }

    @Deprecated
    public static long linearGausSum0(long count) {
        if (count > GAUS_MAX_VAL)
            throw new ArithmeticException("long overflow");
        long sum = 0;
        for (long i = 1; i <= count; i++)
            sum += i;
        return sum;
    }

    /**
     * 1 + 2 + 3 + 4 + ... + 97 + 98 + 99 + 100
     *
     * @param count
     *
     * @return
     */
    public static long gausSum0(long count) {
        if (count > GAUS_MAX_VAL)
            throw new ArithmeticException("long overflow");
        /*
        long mod = count % 2;
        return (count + (1 ^ mod)) * ((count >> 1) + (1 & mod));
        */
        if (count % 2 == 0)
            return (count + 1) * (count >> 1);
        return (count) * ((count >> 1) + 1);
    }

    /**
     * https://en.wikipedia.org/wiki/Euclidean_algorithm
     */
    public static long euclideanAlgorithm(long a, long b) {
        if (a == b)
            return a;

        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return a + b;
    }

    /**
     * https://en.wikipedia.org/wiki/Trial_division
     */
    public static boolean trialDivision(long n) {
        n = Math.abs(n);
        if (n < 4)
            return true;
        if (n % 2 == 0)
            return false;
        final double sqrt = Math.sqrt(n);
        for (long i = 3; i <= sqrt; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    /**
     * Sieve of Eratosthenes
     *
     * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     */
    public static long[] sieveOfEratosthenes(long n) {
        if (n <= 2)
            return new long[]{};
        if (n == 3)
            return new long[]{2};

        final ArrayList<Long> list = new ArrayList<>();
        list.add(2L);
        for (long i = 3; i < n; i++) {
            if (trialDivision(i))
                list.add(i);
        }

        final long[] arr = new long[list.size()];
        for (int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);

        return arr;
    }

    /**
     * @see #linearGausSum0(long)
     */
    @Deprecated
    public static BigInteger linearGausSum(BigInteger count) {
        if (count == null)
            return BigInteger.ZERO;

        if (count.compareTo(GAUS_MAX_VAL_BI) <= 0)
            return BigInteger.valueOf(linearGausSum0(count.longValue()));

        BigInteger sum = BigInteger.ZERO;
        for (BigInteger i = BigInteger.ONE; i.compareTo(count) <= 0; i = i.add(BigInteger.ONE))
            sum = sum.add(i);

        return sum;
    }

    /**
     * @see #gausSum0(long)
     */
    public static BigInteger gausSum(BigInteger count) {
        if (count == null)
            return BigInteger.ZERO;

        if (count.compareTo(GAUS_MAX_VAL_BI) <= 0)
            return BigInteger.valueOf(gausSum0(count.longValue()));

        if (count.mod(BigInteger.TWO).equals(BigInteger.ZERO))
            return count.add(BigInteger.ONE).multiply(count.shiftRight(1));

        return count.multiply(count.shiftRight(1).add(BigInteger.ONE));
    }

    @SuppressWarnings("DuplicatedCode")
    public static long nextPowerOf2(long n) {
        n--;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return n + 1;
    }

    @SuppressWarnings("DuplicatedCode")
    public static long prevPowerOf2(long n) {
        n--;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        n -= (n >> 1);
        return n;
    }

    public static boolean isPowerOfTwo(long n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    public static int digitsCount(int num) {
        return num == 0 ? 1 : (int) (Math.log10(Math.abs(num)) + 1);
    }

    public static int maxDigitsCount(int[] arr) {
        int count = 0;
        for (int value : arr)
            count = Math.max(count, digitsCount(value));
        return count;
    }
}
