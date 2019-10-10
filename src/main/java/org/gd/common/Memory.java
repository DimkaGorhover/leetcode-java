package org.gd.common;

import java.util.StringJoiner;

/**
 * Inspired by {@link java.time.Duration}
 *
 * @see java.time.Duration
 * @since 2019-10-10
 */
public class Memory {

    private final long gbs, bytes;

    private Memory(long gbs, long bytes) {
        this.gbs = gbs;
        this.bytes = bytes;
    }

    public static Memory ofBytes(long value) {
        int d = 1 << 30;
        return new Memory(value / d, value % d);
    }

    public static Memory ofKbs(long value) {
        int d = 1 << 20;
        return new Memory(value / d, value % d);
    }

    public static Memory ofMbs(long value) {
        int d = 1 << 10;
        return new Memory(value / d, value % d);
    }

    public static Memory ofGbs(long value) {
        return new Memory(value, 0);
    }

    public Memory plus(Memory memory) {
        if (memory == null)
            return this;
        long bytes = this.bytes + memory.bytes;
        long gbs = this.gbs + memory.gbs;
        int d = 1 << 30;
        return new Memory(gbs + (bytes / d), bytes % d);
    }

    public Memory minus(Memory memory) {
        if (memory == null)
            return this;
        int d = 1 << 30;
        long bytes = this.bytes - memory.bytes;
        long gbs = this.gbs - memory.gbs;
        if (bytes < 0) {
            bytes = d + bytes;
            gbs--;
        }
        return new Memory(gbs + (bytes / d), bytes % d);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Memory)) return false;
        Memory memory = (Memory) o;
        return gbs == memory.gbs &&
                bytes == memory.bytes;
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(gbs);
        result = 31 * result + Long.hashCode(bytes);
        return result;
    }

    @Override
    public String toString() {
        StringJoiner s = new StringJoiner(", ", "Memory{", "}");
        if (gbs > 0)
            s.add("gbs=" + gbs);
        if (bytes > 0)
            s.add("bytes=" + bytes);
        return s.toString();
    }
}
