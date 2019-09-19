package org.gd.common;

import java.math.BigInteger;

/**
 * @author Horkhover Dmytro
 * @since 2018-12-18
 */
public final class Commons {

    private static final long GAUS_MAX_LAL = 4_294_967_295L;
    private static final BigInteger GAUS_MAX_VAL_BI = BigInteger.valueOf(GAUS_MAX_LAL);

    private static final BigInteger[] BIG_INTEGERS_BITS = new BigInteger[32];

    private static final BigInteger
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

    public static long factorial(int n) {
        if (n > 20)
            throw new ArithmeticException("long overflow");
        long s = 1;
        for (int i = 2; i <= n; i++)
            s = Math.multiplyExact(s, i);
        return s;
    }

    public static BigInteger bigFactorial(int n) {
        if (n < 20) return BigInteger.valueOf(factorial(n));
        if (n == 20) return BIG_FACT_20;
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
        return Math.log10(logNumber) / Math.log10(base);
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
        double half = recursionPow(v, pow / 2);
        return half * half * recursionPow(v, pow % 2);
    }

    public static long linearGausSum0(long count) {
        if (count > GAUS_MAX_LAL)
            throw new ArithmeticException("long overflow");
        long sum = 0;
        for (long i = 1; i <= count; i++)
            sum += i;
        return sum;
    }

    public static long gausSum0(long count) {
        if (count > GAUS_MAX_LAL)
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
     * @see #linearGausSum0(long)
     */
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
}
