package org.gd.common;

/**
 * In numerical analysis, the Kahan summation algorithm (also known as compensated summation[1])
 * significantly reduces the numerical error in the total obtained by adding a sequence
 * of finite precision floating point numbers, compared to the obvious approach.
 * This is done by keeping a separate running compensation (a variable to accumulate small errors).
 */
class KahanAdder implements DoubleAdder {

    private double sum, error;

    KahanAdder(double sum) { this.sum = sum; }

    public static double sum(double[] input) { return sum(input, 0, input.length); }

    public static double sum(double[] input, int offset, int length) {

        if (input == null
                || (length = Math.min(length, input.length)) <= 0
                || length <= (offset = Math.max(0, offset)))
            return 0;

        if (length - offset == 1)
            return input[offset];

        double sum = 0, c = 0, t, y;
        for (int i = offset; i < length; i++) {
            y = input[i] - c;
            t = sum + y;
            c = (t - sum) - y;
            sum = t;
        }
        return sum;
    }

    @Override
    public KahanAdder add(double value) {
        if (!Double.isNaN(value)) {
            double y = value - error, t = sum + y;
            error = (t - sum) - y;
            sum = t;
        }
        return this;
    }

    @Override
    public KahanAdder add(double[] values) { return add(sum(values)); }

    @Override
    public double get() { return sum; }
}
