package org.gd.joma.pi;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-18
 */
class StreamPiCalculator implements PiCalculator {

    static final StreamPiCalculator INSTANCE = new StreamPiCalculator();

    private StreamPiCalculator() {}

    @Override
    public double calc(long count) {
        return LongStream.range(0, count)
                .mapToObj(value -> Point.random())
                .parallel()
                .collect(Collectors.teeing(
                        Collectors.filtering(Point::inCircle, Collectors.counting()),
                        Collectors.counting(),
                        Result::new
                )).pi();
    }
}
