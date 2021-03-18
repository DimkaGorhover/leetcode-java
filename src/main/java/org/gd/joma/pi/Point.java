package org.gd.joma.pi;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-18
 */
record Point(double x, double y) {

    static Point random() {
        var random = ThreadLocalRandom.current();
        return new Point(random.nextDouble(), random.nextDouble());
    }

    boolean inCircle() { return inCircle(x, y); }

    static boolean inCircle(double x, double y) {
        return (x * x + y * y) <= 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point that)) {
            return false;
        }
        return Double.compare(that.x, x) == 0 &&
                Double.compare(that.y, y) == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = Double.hashCode(x);
        result = 31 * result + Double.hashCode(y);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Point{"
                + "x=" + x
                + ", y=" + y
                + '}';
    }
}
