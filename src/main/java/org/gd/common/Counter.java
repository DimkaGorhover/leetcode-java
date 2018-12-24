package org.gd.common;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author Horkhover Dmytro
 * @since 2018-12-24
 */
public interface Counter extends AutoCloseable {

    long TOTAL_MEMORY = Runtime.getRuntime().totalMemory(), MEMORY_THRESHOLD = (long) ((1L << 30) * 0.75);

    static Counter counter() {
        if (TOTAL_MEMORY > MEMORY_THRESHOLD)
            return new LongAdderCounter();
        return new AtomicCounter();
    }

    Counter add(long value);

    @SuppressWarnings("UnusedReturnValue")
    default Counter increment() { return add(1L); }

    long get();

    long getAndClear();

    @Override
    default void close() {}

    // ----- AbstractCounter

    abstract class AbstractCounter implements Counter {

        @Override
        public final boolean equals(Object o) {
            return this == o || ((o instanceof Counter) && get() == ((Counter) o).get());
        }

        @Override
        public final int hashCode() { return Long.hashCode(get()); }

        @Override
        public final String toString() { return getClass().getSimpleName() + "(" + get() + ")"; }
    }

    // ----- LongAdderCounter

    class LongAdderCounter extends AbstractCounter {

        private final LongAdder counter = new LongAdder();

        LongAdderCounter() {}

        @Override
        public Counter add(long value) {
            counter.add(value);
            return this;
        }

        @Override
        public long get() { return counter.sum(); }

        @Override
        public long getAndClear() { return counter.sumThenReset(); }
    }

    // ----- AtomicCounter

    class AtomicCounter extends AbstractCounter {

        private static final AtomicLongFieldUpdater<AtomicCounter> C = AtomicLongFieldUpdater
                .newUpdater(AtomicCounter.class, "c");

        @SuppressWarnings("unused") private volatile long c = 0;

        AtomicCounter() {}

        @Override
        public Counter add(long v) {
            long p;
            do { p = C.get(this); } while (!C.weakCompareAndSet(this, p, Math.addExact(p, v)));
            return this;
        }

        @Override
        public long get() { return C.get(this); }

        @Override
        public long getAndClear() {
            long p;
            do { p = C.get(this); } while (!C.weakCompareAndSet(this, p, 0));
            return p;
        }
    }
}
