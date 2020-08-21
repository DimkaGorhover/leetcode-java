package org.gd.apptopia;

import java.math.BigDecimal;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-19
 */
public class Record implements Comparable<Record> {

    private final int year;
    private final int month;
    private final int day;
    private final BigDecimal value;
    private final long count;

    public Record(int year, int month, int day, BigDecimal value, long count) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.value = value;
        this.count = count;
    }

    public static Record of(String str) {
        if (str == null || (str = str.trim()).isEmpty())
            return null;

        int year = NumberUtils.readInt(str, 0, 4);
        int month = NumberUtils.readInt(str, 5, 2);
        int day = NumberUtils.readInt(str, 8, 2);

        BigDecimal value = new BigDecimal(str.substring(11));

        return new Record(year, month, day, value, 1);
    }

    public static Record merge(Record record1, Record record2) {

        if (record1.compareTo(record2) != 0)
            throw new IllegalArgumentException();

        return new Record(
                record1.year,
                record1.month,
                record1.day,
                record1.value.add(record2.value),
                record1.count + record2.count);
    }

    public BigDecimal getValue() { return value; }

    public long getCount() { return count; }

    @Override
    public int compareTo(Record o) {
        int compare = Integer.compare(year, o.year);
        if (compare != 0)
            return compare;
        compare = Integer.compare(month, o.month);
        if (compare != 0)
            return compare;
        return Integer.compare(day, o.day);
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d:%s", year, month, day, value);
    }
}
