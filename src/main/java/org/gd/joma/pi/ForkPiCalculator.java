package org.gd.joma.pi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-18
 */
class ForkPiCalculator implements PiCalculator {

    private final int parallelism;

    ForkPiCalculator(int parallelism) {
        this.parallelism = Math.max(parallelism, 1);
    }

    private static CompletableFuture<Result> createCompletableFuture(Supplier<Result> supplier) {
        return CompletableFuture.supplyAsync(supplier);
    }

    private CompletableFuture<Result> run(Supplier<Result> supplier) {
        if (parallelism == 1)
            return createCompletableFuture(supplier);

        var async = CompletableFuture.completedFuture(Result.ZERO);
        for (int i = 0; i < parallelism; i++)
            async = async.thenCombine(createCompletableFuture(supplier), Result::merge);
        return async;
    }

    @Override
    public double calc(final long count) {
        return run(() -> {

            long total = 0;
            long inCircle = 0;

            for (int i = 0; i < count / parallelism; i++) {
                double x = ThreadLocalRandom.current().nextDouble();
                double y = ThreadLocalRandom.current().nextDouble();
                total++;
                if (Point.inCircle(x, y))
                    inCircle++;
            }

            return new Result(inCircle, total);

        }).join().pi();
    }
}
