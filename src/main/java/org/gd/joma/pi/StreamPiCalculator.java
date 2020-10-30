package org.gd.joma.pi;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-18
 */
class StreamPiCalculator implements PiCalculator {

    static final StreamPiCalculator INSTANCE = new StreamPiCalculator();

    private final int batchSize;

    StreamPiCalculator() {
        this(1 << 10);
    }

    StreamPiCalculator(int batchSize) {
        if (batchSize < 1)
            throw new IllegalArgumentException("batchSize");
        this.batchSize = batchSize;
    }

    private Result calcOneBatch() {
        long inCircle = 0;
        for (int i = 0; i < batchSize; i++) {
            double x = ThreadLocalRandom.current().nextDouble();
            double y = ThreadLocalRandom.current().nextDouble();
            if (Point.inCircle(x, y))
                inCircle++;
        }
        return new Result(inCircle, batchSize);
    }

    @Override
    public double calc(long count) {
        final long batchCount = Math.max(1L, (long) Math.ceil((double) count / batchSize));
        Result result = LongStream.range(0, batchCount)
                .mapToObj(ignore -> calcOneBatch())
                .parallel()
                .reduce(Result.ZERO, Result::merge);

        return result.pi();
    }
}
