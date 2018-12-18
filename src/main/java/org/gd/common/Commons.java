package org.gd.common;

import java.math.BigInteger;

/**
 * @author Horkhover Dmytro
 * @since 2018-12-18
 */
@SuppressWarnings("WeakerAccess")
public final class Commons {

    private static final BigInteger
            BIG_FIB_91 = BigInteger.valueOf(fib(91)),
            BIG_FIB_92 = BigInteger.valueOf(fib(92));

    private Commons() { throw new UnsupportedOperationException(); }

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
        if (n == 91) return BIG_FIB_91;
        if (n == 92) return BIG_FIB_92;
        if (n < 93) return BigInteger.valueOf(fib(n));
        BigInteger a1 = BIG_FIB_91, a2 = BIG_FIB_92, f = a2;
        for (int i = 93; i <= n; i++) {
            f = a1.add(a2);
            a1 = a2;
            a2 = f;
        }
        return f;
    }
}
