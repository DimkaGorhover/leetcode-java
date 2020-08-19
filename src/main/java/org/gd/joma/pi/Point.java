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
}
