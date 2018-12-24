package org.gd.common;

import java.math.BigInteger;

/**
 * @author Horkhover Dmytro
 * @since 2018-12-18
 */
@SuppressWarnings("WeakerAccess")
public final class Commons {

    private static final BigInteger[] BIG_INTEGERS_BITS = new BigInteger[32];

    private static final BigInteger
            BIG_FIB_91  = BigInteger.valueOf(fib(91)),
            BIG_FIB_92  = BigInteger.valueOf(fib(92)),
            BIG_FACT_20 = BigInteger.valueOf(factorial(20));

    private Commons() { throw new UnsupportedOperationException(); }

    private static BigInteger bigIntegerBits0(int bits) {
        return bits < 63
                ? BigInteger.valueOf(1L << bits)
                : BigInteger.valueOf(2).pow(bits);
    }

    /**
     * @param bits power of two
     *
     * @return {@link BigInteger}
     */
    public static BigInteger bigIntegerBits(int bits) {
        if (bits <= 0)
            return BigInteger.ZERO;
        if (bits < BIG_INTEGERS_BITS.length) {
            BigInteger pow;
            if ((pow = BIG_INTEGERS_BITS[bits]) == null)
                BIG_INTEGERS_BITS[bits] = (pow = bigIntegerBits0(bits));
            return pow;
        }
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
        if (n == 91) return BIG_FIB_91;
        if (n == 92) return BIG_FIB_92;
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
}
