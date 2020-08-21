package org.gd.apptopia;

import java.util.Iterator;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-19
 */
public class Entry implements Comparable<Entry> {

    private final Record record;
    private final Iterator<String> iterator;

    public Entry(Record record, Iterator<String> iterator) {
        this.record = record;
        this.iterator = iterator;
    }

    public static Entry of(Iterator<String> iterator) {
        if (iterator == null || !iterator.hasNext())
            return null;
        Record record = Record.of(iterator.next());
        if (record == null)
            return null;
        return new Entry(record, iterator);
    }

    public Entry next() { return of(iterator); }

    public Entry mergeValues(Entry other) {
        return new Entry(Record.merge(record, other.record), iterator);
    }

    public Record getRecord() { return record; }

    @Override
    public int compareTo(Entry o) {
        return record.compareTo(o.record);
    }

    @Override
    public String toString() {
        return record.toString();
    }
}
