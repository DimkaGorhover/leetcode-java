package org.gd.common;

public interface DoubleAdder {

    static DoubleAdder kahan() { return new KahanAdder(0); }

    DoubleAdder add(double value);

    DoubleAdder add(double[] values);

    double get();
}
