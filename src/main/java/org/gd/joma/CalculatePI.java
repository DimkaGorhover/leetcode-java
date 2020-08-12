package org.gd.joma;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * https://www.youtube.com/watch?v=pvimAM_SLic
 *
 * @author Horkhover Dmytro
 * @since 2020-08-07
 */
class CalculatePI {

    static double calc(long count) {

        return LongStream.range(0, count).parallel()
                .mapToObj(value -> Point.random())
                .collect(Collectors.teeing(
                        Collectors.filtering(Point::inCircle, Collectors.counting()),
                        Collectors.counting(),
                        Result::new
                )).pi();

    }

    static record Result(long inCircle, long total) {

        Result merge(Result o) {
            return new Result((inCircle + o.inCircle), (total + o.total));
        }

        double pi() { return 4d * inCircle / total; }
    }

    static record Point(double x, double y) {

        static Point random() {
            var random = ThreadLocalRandom.current();
            return new Point(random.nextDouble(), random.nextDouble());
        }

        boolean inCircle() { return (x * x + y * y) <= 1; }
    }
}
